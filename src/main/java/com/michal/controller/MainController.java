package com.michal.controller;

import com.michal.domain.Address;
import com.michal.domain.User;
import com.michal.domain.Users;
import com.michal.repository.AddressRepo;
import com.michal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by Mike on 2017-07-07.
 */

@RestController
public class MainController {

    Logger logger = Logger.getLogger(MainController.class.toString());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepo addressRepo;

    @RequestMapping("/user")
    public User getUser() {
        return userRepository.findOne(1L);
    }


    @RequestMapping("/address")
    public Address getAddress(){
        return addressRepo.findOne(1L);
    }

    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_XML_VALUE)
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/htmltext" , produces = MediaType.TEXT_HTML_VALUE)
    public String getHtml(){
        return "<b style='color: red'>HIHO</b>";
    }

    @RequestMapping(value = "/marshal", produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public String getMarshal() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        StringWriter sw = new StringWriter();
        Users users = new Users(userRepository.findAll());

        jaxbMarshaller.marshal(users,sw);
        logger.info(sw.toString());
        return sw.toString();
    }

}
