package com.willow.main;

/**
 * Created by Administrator on 2017/7/5.
 */
public class ExcelUtils {

   /* private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private static final  String url="G:\\EXCEL\\六里坪镇20个村8439人\\";
    public static void main(String[] strings) throws Exception {
       // createXLS();
        createExcel();
    }
    public static void  encryptExcel(String excelFilePath,String excelPassword) throws Exception{
      *//*  File fileSoucre = new File(excelFilePath);
        // Add password protection and encrypt the file
        POIFSFileSystem fs = new POIFSFileSystem();
        EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
        Encryptor enc = info.getEncryptor();

        // set the password
        enc.confirmPassword(excelPassword);

        // encrypt the file
        OPCPackage opc = OPCPackage.open(fileSoucre, PackageAccess.READ_WRITE);
        OutputStream os = enc.getDataStream(fs);
        opc.save(os);
        opc.close();

        // save the file back to the filesystem
        FileOutputStream fos = new FileOutputStream(fileSoucre);
        fs.writeFilesystem(fos);
        fos.close();*//*
    }
    public static void createExcel()  throws Exception{
        List<String> fileList= readfile("G:\\EXCEL\\六里坪镇20个村8439人\\六里坪镇20个村8439人");
       //  List<String> fileList= readfile("G:\\EXCEL\\test");
         for(String fileUrl:fileList){
             List<Object> familyPeople= readExcelFamily(fileUrl);
             createExcelByPeopleList(familyPeople);
         }
     }
    *//**
     * 读取某个文件夹下的所有文件
     *//*
    public static List<String> readfile(String filepath) throws FileNotFoundException, IOException {
        List<String> items=new ArrayList<String>();
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        items.add(readfile.getPath());
                      *//*  System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());*//*

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return items;
    }
    public static void createExcelByPeopleList(List<Object> list) throws Exception {
        String filename="";
        String fileurl="";
        //excel模板路径
      //  List<Object> list = family();
        Map<String,String> nameMap=new HashMap<String,String>() ;
        for (int i = 0, j = list.size(); i < j; i++) {   //循环村为单位
            File fi = new File("G:\\EXCEL\\MODEL.xls");
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
            //读取excel模板
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            wb.writeProtectWorkbook("8654415", "admin");
            //可编辑的单元格样式
            CellStyle unlockedCellStyle = wb.createCellStyle();
            unlockedCellStyle.setLocked(false);
            // 设置密 码 保 护 ·

            //读取了模板内所有sheet内容
            HSSFSheet sheet = wb.getSheetAt(0);
            sheet.protectSheet("8654415");
            //如果这行没有了，整个公式都不会有自动计算的效果的
            sheet.setForceFormulaRecalculation(true);
            List<List<Object>> family=(List<List<Object>>)list.get(i);
            fileurl=family.get(0).get(2).toString().replace("委会","");
            filename=family.get(0).get(2).toString().replace("委会","")+"\\"+family.get(0).get(3).toString();
            Random ran=new Random();
            int peopleNumber=0;
            boolean nameRepeat=false;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            for (int k = 0, m = family.size(); k < m&&k<6; k++) {   //循环家庭为单位
                       List<Object>  people=family.get(k);  //家庭成员
                        List<String> aaa=new LinkedList<String>();
                        aaa.add("有");
                        aaa.add("无");
                        aaa.add("一组");
                        aaa.add("二组");
                        aaa.add("钢混");
                        aaa.add("砖混");
                         HSSFCell cell3 = sheet.getRow(2+k).getCell(7);
                        if(people.get(13).toString().equals("技能劳动力")||people.get(13).toString().equals("普通劳动力")){
                            peopleNumber++;
                            cell3.setCellValue(aaa.get(0));  //劳动技能
                        }else{
                            cell3.setCellValue(aaa.get(1));  //劳动技能
                        }
                        if(k==m-1) {   //
                            HSSFCell cell11 = sheet.getRow(9).getCell(7);//
                            cell11.setCellValue(peopleNumber);  //劳动人口
                        }
                            //logger.info(list.get(i).get(3).toString());
                        HSSFCell cell = sheet.getRow(2+k).getCell(1);//第11行 第6列
                        cell.setCellValue(people.get(5).toString());  //姓名
                        cell.setCellStyle(unlockedCellStyle);
                        HSSFCell cell1 = sheet.getRow(2+k).getCell(2);
                        cell1.setCellValue(people.get(8).toString());  //与户主关系
                        HSSFCell cell2 = sheet.getRow(2+k).getCell(3);
                        cell2.setCellValue(people.get(7).toString());  //身份证号


                        int t0 = ran.nextInt(1 - 0 + 1) + 0;   //收入

                        HSSFCell cell4 = sheet.getRow(2+k).getCell(8);//第11行 第6列
                        cell4.setCellValue(people.get(10).toString());  //文化程度
                        //String oldname= nameMap.get(people.get(5).toString());
                        if(*//*oldname!=null&&"0000".equals(oldname)&&*//*nameRepeat) {
                            filename=filename+"("+people.get(5).toString()+")";
                            nameRepeat=false;
                            System.out.println("户主姓名重复！村：" + people.get(2).toString().replace("委会","") + "；姓名：" + people.get(3).toString());
                        }
                     *//*   HSSFCell cell5 = sheet.getRow(2+k).getCell(2);//第11行 第6列
                        cell5.setCellValue(people.get(11).toString());  //文化程度*//*
                     if(k==0){   //公共信息
                         HSSFCell cell5 = sheet.getRow(10).getCell(1);//
                         cell5.setCellValue(people.get(0).toString());  //市
                         HSSFCell cell6 = sheet.getRow(10).getCell(2);//
                         cell6.setCellValue(people.get(1).toString());  //镇
                         HSSFCell cell7 = sheet.getRow(10).getCell(3);//
                         cell7.setCellValue(people.get(2).toString().replace("委会", ""));  //村
                         HSSFCell cell8 = sheet.getRow(10).getCell(4);//
                         int tt = ran.nextInt(3 - 2 + 1) + 2;   //收入
                         cell8.setCellValue(aaa.get(tt));  //劳动技能
                         HSSFCell cell9 = sheet.getRow(9).getCell(5);//
                         cell9.setCellValue("是");  //是否富平对象

                         HSSFCell cell10 = sheet.getRow(9).getCell(6);//
                         cell10.setCellValue(m);  //家庭人口

                         int t = ran.nextInt(30 - 10 + 1) + 10;   //收入
                         HSSFCell cell12 = sheet.getRow(15).getCell(4);//
                         cell12.setCellValue(t*0.1);  //收入
                         Double t11 = (ran.nextInt(t - 10 + 1) + 10)*0.1;   //支出

                         HSSFCell cell121 = sheet.getRow(15).getCell(3);//
                         cell121.setCellValue(t11);  //经营收入
                         HSSFCell cell122 = sheet.getRow(16).getCell(3);//
                         cell122.setCellValue(t*0.1-t11);  //劳动收入


                         Double t2 = (ran.nextInt(t - 10 + 1) + 10)*0.1;   //支出
                         HSSFCell cell13 = sheet.getRow(15).getCell(10);//
                         cell13.setCellValue(t2);  //支出

                         HSSFCell cell131 = sheet.getRow(15).getCell(8);//
                         cell131.setCellValue(t2);  //支出


                         int t3 = ran.nextInt(115 - 75 + 1) + 75;   //房屋面积
                         HSSFCell cell14 = sheet.getRow(20).getCell(3);//
                         cell14.setCellValue(t3);  //房屋面积

                         Date randomDate = randomDate("2009-01-01", "2015-03-01");

                         String date = format.format(randomDate);
                         HSSFCell cell15 = sheet.getRow(20).getCell(5);//
                         cell15.setCellValue(date);  //建造时间

                         int t4 = ran.nextInt(300 - 100 + 1) + 100;   //土地面积
                         HSSFCell cell16 = sheet.getRow(20).getCell(7);//
                         cell16.setCellValue(t4*0.01);  //土地面积

                         int t5 = ran.nextInt(300 - 100 + 1) + 100;   //山林面积
                         HSSFCell cell17 = sheet.getRow(22).getCell(2);//
                         cell17.setCellValue(t5*0.01);  //山林面积

                         int t6 = ran.nextInt(300 - 100 + 1) + 100;   //土地面积
                         HSSFCell cell18 = sheet.getRow(22).getCell(7);//
                         cell18.setCellValue(t6*0.01);  //土地面积

                         int t7 = ran.nextInt(5 - 1 + 1) + 1;   //山林面积
                         HSSFCell cell19 = sheet.getRow(24).getCell(2);//
                         cell19.setCellValue(t7);  //滩涂面积
                         HSSFCell cell20 = sheet.getRow(0).getCell(0);//标题
                         cell20.setCellValue(people.get(0).toString()+people.get(1).toString()+people.get(2).toString().replace("委会", "")+"农户信用信息采集表");  //土地面积
                         int ttt = ran.nextInt(5 - 4 + 1) +4;
                         HSSFCell cell22 = sheet.getRow(20).getCell(2);
                         cell22.setCellValue(aaa.get(ttt));  //房屋结构
                         String oldname2= nameMap.get(people.get(3).toString());
                         if(oldname2==null||"".equals(oldname2)) {
                             nameMap.put(people.get(3).toString(), people.get(5).toString());
                         }else{
                             //nameMap.put(people.get(5).toString(), "0000");
                              nameRepeat=true;
                         }
                     }
            }




            String date = format.format(new Date());
            createDir(url + fileurl);
            FileOutputStream out = new FileOutputStream(url+filename+"-"+date+".xls");
            wb.write(out);
            out.close();

        }
    }

    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
    public static List<Object> readExcelFamily(String filepath) throws Exception{
        File oldExcel = new File(filepath);
        List<List<Object>> list = FileUtil.read2003Excel(new FileInputStream(oldExcel));
        List<Object> arrObj=new LinkedList<Object>();
        List<List<Object>> family=null;
        //父节点
        String parentIdStr = null;

        for (int i = 1, j = list.size(); i < j; i++) {
            if(list.get(i).get(4).toString()!=null&&list.get(i).get(4).toString().equals(parentIdStr)) {
                family.add(list.get(i));
                if(family.size()>6){
                    System.out.println("大于6的家庭成员！" + list.get(i).get(2).toString() + "-" + list.get(i).get(3).toString());
                }
            } else {
                if(family!=null&&family.size()>=2){
                    for (int k = 0, m = family.size(); k < m; k++) {   //循环家庭为单位
                        List<Object>  people=family.get(k);  //家庭成员
                        if(people.get(8).equals("户主")&&k!=0){
                            family.remove(k);
                            family.add(0,people);
                        }
                    }
                }
                family=new LinkedList<List<Object>>();
                family.add(list.get(i));
                arrObj.add(family);
            }
            parentIdStr =list.get(i).get(4).toString();
        }
        System.out.println(list.get(1).get(2).toString() + "-统计人数：" +list.size()+ ";统计家庭户数：" + arrObj.size());
        return arrObj;
    }
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {// 判断目录是否存在
           // System.out.println("创建目录失败，目标目录已存在！");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
            destDirName = destDirName + File.separator;
        }
        if (dir.mkdirs()) {// 创建目标目录
         //   System.out.println("创建目录成功！" + destDirName);
            return true;
        } else {
           // System.out.println("创建目录失败！");
            return false;
        }
    }
*/
}
