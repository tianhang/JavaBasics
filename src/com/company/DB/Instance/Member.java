package com.company.DB.Instance;

import com.company.DB.Annotation.DBTable;
import com.company.DB.Annotation.*;
/**
 * Created by tianhang on 30/8/2016.
 */
@DBTable
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;
    public String getHandle() { return handle; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String toString() { return handle; }
    public Integer getAge() { return age; }
}
