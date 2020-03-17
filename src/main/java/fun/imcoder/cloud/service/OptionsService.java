package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Options;

import java.util.List;

public interface OptionsService extends BaseService<Options> {
    Boolean save(List<Options> list);
}
