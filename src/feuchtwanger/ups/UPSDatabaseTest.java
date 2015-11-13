package feuchtwanger.ups;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase d = new UPSDatabase();
		d.sendPackage("1", 3L, 4L);
		Set<Package> packages = new HashSet<Package>();
		packages.add(new Package("1"));
		Assert.assertEquals(packages, d.getPackages(new Location(3L, 4L)));
		Assert.assertEquals(new Location(3L, 4L), d.getLocation(new Package("1")));
	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase d = new UPSDatabase();
		d.sendPackage("1", 3L, 4L);
		Location l = new Location(5L, 6L);
		d.updatePackageLocation(new Package("1"), new Location(5L, 6L));
		Set<Package> packages = new HashSet<Package>();
		packages.add(new Package("1"));
		Assert.assertEquals(packages, d.getPackages(l));
		Assert.assertEquals(l, d.getLocation(new Package("1")));
		packages = new HashSet<Package>();
		Assert.assertEquals(packages, d.getPackages(new Location(3L, 4L)));
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase d = new UPSDatabase();
		d.addLocation(1L, 2L);
		Set<Package> packages = new HashSet<Package>();

		Assert.assertEquals(packages, d.getPackages(new Location(1L, 2L)));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase d = new UPSDatabase();

		Assert.assertNull(d.getLocation(new Package("3")));
	}

}
