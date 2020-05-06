package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.ExtField;

public interface ExtFieldService extends BaseService<ExtField> {

    Boolean deleteExtField(ExtField extField);

}
