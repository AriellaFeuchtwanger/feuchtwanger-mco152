package feuchtwanger.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	private HashMap<Package, Location> packages;
	private HashMap<Location, Set<Package>> locations;

	public UPSDatabase() {
		packages = new HashMap<Package, Location>();
		locations = new HashMap<Location, Set<Package>>();
	}

	public void addLocation(long latitude, long longitude) {
		locations.put(new Location(latitude, longitude), new HashSet<Package>());
	}

	public void sendPackage(String trackingNumber, long latitude, long longitude) {
		Location temp = new Location(latitude, longitude);
		if (!locations.containsKey(temp)) {
			addLocation(latitude, longitude);
		}

		Package p = new Package(trackingNumber);
		addPackageToLocation(temp, p);
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		packages.put(pkg, location);
		Set<Package> pkgs = locations.get(location);
		pkgs.add(new Package(pkg.getTrackingNumber()));
		locations.put(location, pkgs);
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		Location temp = packages.get(pkg);
		packages.put(pkg, location);
		if (!locations.containsKey(location)) {
			addLocation(location.getLatitude(), location.getLongitude());
		}
		Set<Package> pkgs = locations.get(location);
		pkgs.add(new Package(pkg.getTrackingNumber()));
		locations.put(location, pkgs);
		removePackage(temp, pkg);
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		return locations.get(location);
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		Location location = packages.get(pkg);
		return location;
	}

	private void removePackage(Location location, Package pkg) {
		Set<Package> packages = locations.get(location);
		packages.remove(pkg);

		locations.put(location, packages);
	}
}
