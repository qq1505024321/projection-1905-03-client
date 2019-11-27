package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.Subject;
import com.jk.service.SubjectService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ccl
 * @create 2019/11/20
 * @since 1.0.0
 */
@Controller
@RequestMapping("subject")
public class SubjectController {

    @Reference
    private SubjectService subjectService;

    @RequestMapping("toSubject")
    public String toSubject(){
        return "subject";
    }

    @RequestMapping("selectSubject")
    public String selectSubject(){
        return "subject";
    }


    @Autowired
    private SolrClient client;


    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @RequestMapping("selectAll2")
    @ResponseBody
    public List<Subject> selectAll2(String subName){

        System.out.println(subName+"===subname=============");

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");



        //返回到前台
        Map<String, Object> map1=new HashMap<>();

        try {
            //存放所有的查询条件
            SolrQuery params = new SolrQuery();

        /*    //查询条件, 这里的 q 对应 下面图片标红的地方
            if(subName!=null && !"".equals(subName)){
                params.set("q", subName);
            }else {
                params.set("q", "*:*");
            }*/

            //过滤条件
            if(subName!=null && !"".equals(subName)){

                params.set("q","product_keywords:"+subName);

            }else {
                params.set("q", "*:*");
            }



            //排序
            params.addSort("subjectTime", SolrQuery.ORDER.desc);

         /*   //分页
            if(page==null){
                params.setStart(0);
            }else {
                params.setStart((page-1)*rows);
            }
            if(rows==null){
                params.setRows(5);
            }else {
                params.setRows(rows);
            }
*/

            //默认域
            // params.set("df", "subjectname");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("subjectName");
            params.addHighlightField("subName");
            params.addHighlightField("courselevel");
            params.addHighlightField("teacherlevel");
            params.addHighlightField("userName");
            params.addHighlightField("subInfo");

            //  params.addHighlightField("subjectName");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            //查询后返回的对象
            QueryResponse queryResponse = client.query("core1",params);
            //查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            //查询的总条数
            long numFound = results.getNumFound();

            System.out.println(numFound);

            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();

            //创建list集合接收我们循环的参数
            List<Subject> list1 =new ArrayList<>();
            for (SolrDocument result : results) {

                Subject subject2 = new Subject();
                String highFile="";

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("subjectName");
                if(list==null){
                    highFile= result.get("subjectName").toString();
                }else {
                    highFile=list.get(0);
                }

             /*   subject2.setTeacherlevelid(Integer.parseInt(result.get("teacherlevelid").toString()));
                subject2.setSubId(Integer.parseInt(result.get("subId").toString()));
                subject2.setCourselevelid(Integer.parseInt(result.get("courselevelid").toString()));*/

                subject2.setTeacherlevelid((Integer)result.get("teacherlevelid"));
                subject2.setSubId((Integer)result.get("subId"));
                subject2.setCourselevelid((Integer)result.get("courselevelid"));



                subject2.setSubjectId(Integer.parseInt(result.get("id").toString()));
                subject2.setSubjectName((String)result.get("subjectName"));
                subject2.setSubName((String)result.get("subName"));
                subject2.setCourselevel((String)result.get("courselevel"));
                subject2.setTeacherlevel((String)result.get("teacherlevel"));
                subject2.setUserName((String)result.get("userName"));
                subject2.setSubImg((String) result.get("subImg"));
                subject2.setSubInfo((String) result.get("subInfo"));

                subject2.setSubjectName(highFile);

                list1.add(subject2);
            }
            System.out.println(list1+"==========solr=========================================");
      /*      map1.put("total",numFound);
            map1.put("rows",list1);*/
            return list1;

        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }

   @RequestMapping("details")
    public String details(Integer id, HttpServletRequest request) throws IOException, SolrServerException {
        System.out.println(id+"+++++++++++++++++++=");
        SolrDocument doc = client.getById("core1", String.valueOf(id));
        doc.toString();
        System.out.println(doc);

       Subject subject = new Subject();
        subject.setTeacherlevelid((Integer)doc.get("teacherlevelid"));
        subject.setSubId((Integer)doc.get("subId"));
        subject.setCourselevelid((Integer)doc.get("courselevelid"));
        subject.setSubjectId(Integer.parseInt(doc.get("id").toString()));
        subject.setSubjectName((String) doc.get("subjectName"));
        subject.setSubName((String) doc.get("subName"));
        subject.setCourselevel((String) doc.get("courselevel"));
        subject.setTeacherlevel((String) doc.get("teacherlevel"));
        subject.setUserName((String) doc.get("userName"));
        subject.setSubImg((String) doc.get("subImg"));
        subject.setSubInfo((String) doc.get("subInfo"));

        System.out.println(subject+"============sub======");

        request.getSession().setAttribute("subject", subject);
        return "details";
    }
}