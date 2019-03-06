package com.qfedu.action;

import com.qfedu.domain.Document;
import com.qfedu.mapper.DocumentDao;
import com.qfedu.service.DocumentService;
import javafx.scene.control.cell.MapValueFactory;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DocumentAction {

    @Autowired
    private DocumentService documentService;
    private DocumentDao documentDao;

    @RequestMapping(value = "getAllDocuments",method = RequestMethod.POST)
    @ResponseBody
    public List<Document> getAllDocuments() throws Exception{
        List<Document> documents = documentService.getAllDocuments();

        System.out.println(documents);
        return documents;
    }


    @RequestMapping(value = "deleteDocumentAction")
    @ResponseBody
    public void deleteDocument(String id) throws Exception{
        int idNumber  = Integer.parseInt(id.split("-")[1]);
       documentService.removeDocumentsById(idNumber);
    }
    @RequestMapping(value = "deleteMoreDocument")
    @ResponseBody
    public void deleteAllDocument(@RequestParam("ids") Integer[] ids)throws Exception{
        System.out.println("test");
        System.out.println(ids);
        documentDao.deleteMoreDocument(ids);
    }


}
