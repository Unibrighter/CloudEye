package com.harvest;

import com.utils.UtilHelper;
import com.utils.log.FileUtils;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;
import twitter4j.json.DataObjectFactory;

public class TiwtterHarvest {

    // private static final String statusJsonText =
    // "{\"in_reply_to_status_id_str\":null,\"place\":null,\"in_reply_to_user_id\":null,\"text\":\"working\",\"contributors\":null,\"retweet_count\":0,\"in_reply_to_user_id_str\":null,\"retweeted\":false,\"id_str\":\"794626207\",\"source\":\"\\u003Ca
    // href=\\\"http:\\/\\/twitterhelp.blogspot.com\\/2008\\/05\\/twitter-via-mobile-web-mtwittercom.html\\\"
    // rel=\\\"nofollow\\\"\\u003Emobile
    // web\\u003C\\/a\\u003E\",\"truncated\":false,\"geo\":null,\"in_reply_to_status_id\":null,\"favorited\":false,\"user\":{\"show_all_inline_media\":false,\"geo_enabled\":false,\"profile_background_tile\":false,\"time_zone\":null,\"favourites_count\":0,\"description\":null,\"friends_count\":0,\"profile_link_color\":\"0084B4\",\"location\":null,\"profile_sidebar_border_color\":\"C0DEED\",\"id_str\":\"14481043\",\"url\":null,\"follow_request_sent\":false,\"statuses_count\":1,\"profile_use_background_image\":true,\"lang\":\"en\",\"profile_background_color\":\"C0DEED\",\"profile_image_url\":\"http:\\/\\/a3.twimg.com\\/a\\/1292975674\\/images\\/default_profile_3_normal.png\",\"profile_background_image_url\":\"http:\\/\\/a3.twimg.com\\/a\\/1292975674\\/images\\/themes\\/theme1\\/bg.png\",\"followers_count\":44,\"protected\":false,\"contributors_enabled\":false,\"notifications\":false,\"screen_name\":\"Yusuke\",\"name\":\"Yusuke\",\"is_translator\":false,\"listed_count\":1,\"following\":false,\"verified\":false,\"profile_text_color\":\"333333\",\"id\":14481043,\"utc_offset\":null,\"created_at\":\"Tue
    // Apr 22 21:49:13 +0000
    // 2008\",\"profile_sidebar_fill_color\":\"DDEEF6\"},\"id\":794626207,\"coordinates\":null,\"in_reply_to_screen_name\":null,\"created_at\":\"Tue
    // Apr 22 21:49:34 +0000 2008\"}";

    public static void main(String[] args) throws TwitterException {
        String json = FileUtils.getInstance()
                .read("/Users/zhangyu/Desktop/SecondTweets.txt");
        System.out.println(json);
        String sr = UtilHelper.forJSON(json);
        System.out.println(sr);
        Object o = TwitterObjectFactory.createObject(sr);
        Status s = null;
        if (o instanceof Status) {
            s = (Status) o;
        }

        System.out.println(s.toString());

    }
}
