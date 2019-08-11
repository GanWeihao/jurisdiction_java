package org.item.jurisdiction.service;

import java.text.ParseException;
import java.util.List;
import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.Rules;
import org.item.jurisdiction.model.UserRole;

public interface RulesService {
  List findByRole(String paramString);
  
  List findAllRules();
  
  List findByUserId(String paramString);
  
  List findAll();
  
  int delall(String paramString);
  
  int addUserRole(UserRole paramUserRole);
  
  int delRole(String paramString);
  
  String addRole(Role paramRole);
  
  int delRoleRules(RoleRules paramRoleRules);
  
  int setRules(RoleRules paramRoleRules);
  
  Role findByRoleId(String paramString);
  
  List findallRulesWithMenu() throws ParseException;
  
  int inserrules(Rules paramRules);
  
  int deleteRules(String paramString);
  
  int deleteRoleRules(String paramString);
  
  int updateRules(Rules paramRules);
  
  List findAllMenu();
  
  List selectAllUrl();
}