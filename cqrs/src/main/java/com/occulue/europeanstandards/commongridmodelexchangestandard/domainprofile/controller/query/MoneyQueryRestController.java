/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity Money.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Money")
public class MoneyQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a Money using a UUID
   *
   * @param UUID moneyId
   * @return Money
   */
  @GetMapping("/load")
  public Money load(@RequestParam(required = true) UUID moneyId) {
    Money entity = null;

    try {
      entity = MoneyBusinessDelegate.getMoneyInstance().getMoney(new MoneyFetchOneSummary(moneyId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load Money using Id " + moneyId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all Money business objects
   *
   * @return Set<Money>
   */
  @GetMapping("/")
  public List<Money> loadAll() {
    List<Money> moneyList = null;

    try {
      // load the Money
      moneyList = MoneyBusinessDelegate.getMoneyInstance().getAllMoney();

      if (moneyList != null) LOGGER.log(Level.INFO, "successfully loaded all Moneys");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all Moneys ", exc);
      return null;
    }

    return moneyList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Money money = null;
  private static final Logger LOGGER = Logger.getLogger(MoneyQueryRestController.class.getName());
}
