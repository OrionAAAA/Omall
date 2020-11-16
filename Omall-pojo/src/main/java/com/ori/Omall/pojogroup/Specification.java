package com.ori.Omall.pojogroup;

/**
 * Created by Orion on 2020/11/16 10:36
 */

import com.ori.Omall.pojo.TbSpecification;
import com.ori.Omall.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * 规格组合实体类
 *
 * 前端 ： entity={specificationOptionList:[]}
 * @author Administrator
 *
 */
public class Specification implements Serializable {

        private TbSpecification specification;

        private List<TbSpecificationOption> specificationOptionList; //TbSpecificationOption  ${tSpecificationOption}

        public TbSpecification getSpecification() {
            return specification;
        }

        public void setSpecification(TbSpecification specification) {
            this.specification = specification;
        }

        public List<TbSpecificationOption> getSpecificationOptionList() {
            return specificationOptionList;
        }

        public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
            this.specificationOptionList = specificationOptionList;
        }


}
