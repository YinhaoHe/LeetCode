import java.io.*;
import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

class Solution {
  public static String[] solution(int min_cheermote_amount, String[] valid_cheermotes, String messages) {
    // Please write your code here.
    // return new String[]{ "a", "b" };
    String[] msgList = messages.trim().split(",");

    // store all valid cheer motes into a hashset
    HashSet<String> validSet = new HashSet<>();
    for (String valid_cheermote : valid_cheermotes) {
      validSet.add(valid_cheermote);
      System.out.println(valid_cheermote);
    }

    HashMap<String, Integer> map = new HashMap<>();

    for (String message : msgList) {
      // String[] segments = message.split(" ");
      Queue<Character> que = new LinkedList<>();
      for (int i = 0; i < message.length(); ++i) {
        char c = message.charAt(i);
        if (Character.isLetter(c)) {
          que.add(message.charAt(i));
        } else if (Character.isDigit(c)) {
          StringBuilder sb = new StringBuilder();
          while (!que.isEmpty()) {
            sb.append(que.poll());
          }

          String cheermote = sb.toString(); // cheermote
          System.out.println(cheermote);
          System.out.println(validSet.contains(cheermote));

          if (validSet.contains(cheermote)) {
            while (i < message.length() && Character.isDigit(message.charAt(i))) {
              System.out.println(message.charAt(i));
              que.add(message.charAt(i));
              ++i;
            }
            i--;
          }

          StringBuilder numSb = new StringBuilder();
          while (!que.isEmpty()) {
            numSb.append(que.poll());
          }
          int number = Integer.parseInt(numSb.toString()); // bits number
          System.out.println(number);

          if (number < min_cheermote_amount && number < 10000) {
            break;
          } else {
            if (!map.containsKey(cheermote)) {
              map.put(cheermote, number);
            } else {
              map.put(cheermote, map.get(cheermote) + number);
            }
          }

        } else {
          while (!que.isEmpty())
            que.poll();
        }
      }
    }

    if (map.size() > 0) {
      String[] result = new String[map.size()];

      List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
      list.sort(new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
          return o2.getValue().compareTo(o1.getValue());
        }
      });

      for (int i = 0; i < list.size(); i++) {
        result[i] = new String(list.get(i).getKey() + list.get(i).getValue());
      }
      return result;
    } else {
      return new String[] { "NO_CHEERS" };
    }
  }

  public static void main(String[] args) {
    int min_cheermote_amount = 1;
    // [1, ["party"], "cheer1"]
    String[] valid_cheermotes = { "cheer", "party" };
    String messages = "cheer1 cheer2, cheer4,party100 cheer1";
    String res[] = solution(min_cheermote_amount, valid_cheermotes, messages);
    for (String re : res) {
      System.out.println(re);
    }
  }
}
