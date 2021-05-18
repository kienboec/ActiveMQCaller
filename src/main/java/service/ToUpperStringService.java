package service;

import service.BaseService;

public class ToUpperStringService extends BaseService {

    @Override
    protected String executeInternal(String input) {
        return input.toUpperCase();
    }
}
