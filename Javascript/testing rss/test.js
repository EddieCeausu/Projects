/**
 * @Author: Edmond Ceausu <eddieceausu>
 * @Date:   2018-12-25T18:23:26-05:00
 * @Email:  eddieswim101@gmail.com
 * @Filename: test.js
 * @Last modified by:   eddieceausu
 * @Last modified time: 2018-12-25T18:25:07-05:00
 * @Copyright: © Edmond Ceausu 2018
 */

 $(document).ready(function() {

 	var url = 'http://rss.nytimes.com/services/xml/rss/nyt/Politics.xml';
 	
 	feednami.load(url,function(result){
 		if(result.error) {
 			console.log(result.error);
 		} else {
 			var entries = result.feed.entries;
 			for(var i = 0; i < entries.length; i++){
 				var entry = entries[i];
 				console.dir(entry);
 			}
 		}
 	});

 });
