package com.wang.config;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {
	/**
	 *                  ___====-_  _-====___
	 *            _--^^^#####//      \\#####^^^--_
	 *         _-^##########// (    ) \\##########^-_
	 *        -############//  |\^^/|  \\############-
	 *      _/############//   (@::@)   \\############\_
	 *     /#############((     \\//     ))#############\
	 *    -###############\\    (oo)    //###############-
	 *   -#################\\  / VV \  //#################-
	 *  -###################\\/      \//###################-
	 * _#/|##########/\######(   /\   )######/\##########|\#_
	 * |/ |#/\#/\#/\/  \#/\##\  |  |  /##/\#/  \/\#/\#/\#| \|
	 * `  |/  V  V  `   V  \#\| |  | |/#/  V   '  V  V  \|  '
	 *    `   `  `      `   / | |  | | \   '      '  '   '
	 *                     (  | |  | |  )
	 *                    __\ | |  | | /__
	 *                   (vvv(VVV)(VVV)vvv)                
	 *                        神兽保佑
	 *                       代码无BUG!
	 */
	 public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
	        File targetFile = new File(filePath);
	        if(!targetFile.exists()){
	            targetFile.mkdirs();
	        }
	        FileOutputStream out = new FileOutputStream(filePath+fileName);
	        out.write(file);
	        out.flush();
	        out.close();
	    }

	 
}
