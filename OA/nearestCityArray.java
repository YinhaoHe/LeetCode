import java.util.*;
import java.io.*;
import java.lang.*;

//If no other cities share an x or y coordinate, return null
public class Solution {

    static class Pin {
        String name;
        int x;
        int y;

        public Pin(String name_, int x_, int y_) {
            name = name_;
            x = x_;
            y = y_;
        }

        public int dist(Pin otherPin) {
            return Math.abs(x - otherPin.x) + Math.abs(y - otherPin.y);
        }
    }

    public String[] findNearestCities(int numOfPoints, String[] points, int[] xCoordinates, int[] yCoordinates,
            int numOfQueriedPoints, String[] queriedPoints) {
        Map<Integer, ArrayList<Pin>> xTopins = new HashMap<>();
        Map<Integer, ArrayList<Pin>> yTopins = new HashMap<>();
        Map<String, Pin> pinByName = new HashMap<>();
        for (int i = 0; i < numOfPoints; i++) {
            String pinName = points[i];
            int x = xCoordinates[i];
            int y = yCoordinates[i];
            Pin pin = new Pin(pinName, x, y);
            xTopins.computeIfAbsent(x, v -> new ArrayList<>());
            yTopins.computeIfAbsent(y, v -> new ArrayList<>());
            xTopins.get(x).add(pin);
            yTopins.get(y).add(pin);
            pinByName.put(pinName, pin);
        }
        List<String> ans = new ArrayList<>();
        Map<String, String> cache = new HashMap<>();
        for (String name : queriedPoints) {
            if (cache.containsKey(name)) {
                ans.add(cache.get(name));
                continue;
            }
            Pin pin = pinByName.get(name);
            int minDist = Integer.MAX_VALUE;
            String closest = null;
            List<Pin> searchpins = xTopins.get(pin.x);
            searchpins.addAll(yTopins.get(pin.y));
            for (Pin otherPin : searchpins) {
                if (otherPin.equals(pin)) {
                    continue;
                }
                int dist = pin.dist(otherPin);
                if (closest == null || dist < minDist || (dist == minDist && otherPin.name.compareTo(closest) < 0)) {
                    minDist = pin.dist(otherPin);
                    closest = otherPin.name;
                }
            }
            if (closest != null) {
                ans.add(closest);
                cache.put(name, closest);
            } else {
                ans.add(null);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
