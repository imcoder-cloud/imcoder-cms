package fun.imcoder.cloud.service;

import fun.imcoder.cloud.base.BaseService;
import fun.imcoder.cloud.model.Label;

public interface LabelService extends BaseService<Label> {
    Label saveLabel(Label label) throws Exception;

    Label updateLabel(Label label) throws Exception;
}
