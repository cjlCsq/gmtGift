package com.example.demo.biz;

import org.springframework.transaction.annotation.Transactional;

public abstract class TransactionBiz<REQ, RES> extends BaseBiz<REQ, RES> {

  @Override
  @Transactional
  public RES process(final REQ req) {
    return super.process(req);
  }

}
