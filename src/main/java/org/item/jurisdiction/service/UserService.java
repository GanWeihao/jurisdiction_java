package org.item.jurisdiction.service;

import java.text.ParseException;
import java.util.List;
import org.item.jurisdiction.model.User;

public interface UserService {
  List findAllUser() throws ParseException;
  
  int updateHead(User paramUser);
  
  int updateName(User paramUser);
  
  int delEmail(String paramString);
  
  int updateEmail(String paramString1, String paramString2);
  
  User userLogin(String paramString1, String paramString2, String paramString3) throws ParseException;
  
  int loginFirst(String paramString);
  
  User findByUserId(String paramString) throws ParseException;
  
  List findMenuByUserId(String paramString);
  
  List findRulesById(String paramString);
  
  List findRoleByUserId(String paramString);
  
  String userAdd(User paramUser);
  
  List findByUserName(String paramString);
  
  List findByUserEmail(String paramString);
  
  List findByUserTel(String paramString);
  
  int deleteUser(String paramString);
  
  int updateUser(User paramUser);
}