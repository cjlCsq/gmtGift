package com.example.demo.biz;

import com.example.demo.exception.BussinessRuleException;
import com.example.demo.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;


@Slf4j
public abstract class BaseBiz<REQ, RES> {
  protected abstract void validateRequest(REQ req) throws InvalidInputException;

  protected void authorize(REQ req) throws BussinessRuleException {}

  protected RES doBiz(REQ req)  {
    throw new NotImplementedException("do biz is not implemented in " + this.getClass());
  }
  private boolean isServerSideException(final Throwable ex) {
    return !(ex instanceof InvalidInputException) && !(ex instanceof BussinessRuleException);
  }

  public RES process(REQ req) {
    // TODO add metrics
    log.info("start biz {}, {}", this.getClass(), req);

    try {
      validateRequest(req);
      authorize(req);
      return doBiz(req);
    } catch (Throwable ex) {
      if (isServerSideException(ex)) {
        log.error(ex.getMessage(), ex);
      } else {
        log.warn(ex.getMessage(), ex);
      }

      throw ex;
    } finally {
      // TODO record metric time
    }
  }
}
