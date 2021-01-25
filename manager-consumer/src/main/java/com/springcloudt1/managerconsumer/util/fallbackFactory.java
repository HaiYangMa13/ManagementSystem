package com.springcloudt1.managerconsumer.util;

import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerconsumer.Service.EmpService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class fallbackFactory implements FallbackFactory {
    public EmpService create (Throwable throwable) {
        return new EmpService() {
            public List pager (int pageNo, int pageSize) {
                return null;
            }

            public void del (int id) {

            }

            public List loadRole () {
                return null;
            }

            public List loadDept () {
                return null;
            }

            public List show () {
                System.out.println("发生错误");
                return null;
            }

            public List count () {
                return null;
            }

            public List add (Emp data) {
                return null;
            }

            public List update (Emp data) {
                return null;
            }

            public void delAll (int[] id) {

            }

            public List search (String name) {
                return null;
            }
        };
    }
}
