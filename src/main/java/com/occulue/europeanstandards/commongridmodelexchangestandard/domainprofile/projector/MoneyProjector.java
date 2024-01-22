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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Money as outlined for the CQRS pattern. All event handling and query handling
 * related to Money are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by MoneyAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("money")
@Component("money-projector")
public class MoneyProjector extends MoneyEntityProjector {

  // core constructor
  public MoneyProjector(MoneyRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateMoneyEvent
   */
  @EventHandler(payloadType = CreateMoneyEvent.class)
  public void handle(CreateMoneyEvent event) {
    LOGGER.info("handling CreateMoneyEvent - " + event);
    Money entity = new Money();
    entity.setMoneyId(event.getMoneyId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMoney(entity);
  }

  /*
   * @param	event UpdateMoneyEvent
   */
  @EventHandler(payloadType = UpdateMoneyEvent.class)
  public void handle(UpdateMoneyEvent event) {
    LOGGER.info("handling UpdateMoneyEvent - " + event);

    Money entity = new Money();
    entity.setMoneyId(event.getMoneyId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());
    entity.setValue(event.getValue());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMoney(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMoney(entity);
  }

  /*
   * @param	event DeleteMoneyEvent
   */
  @EventHandler(payloadType = DeleteMoneyEvent.class)
  public void handle(DeleteMoneyEvent event) {
    LOGGER.info("handling DeleteMoneyEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Money entity = delete(event.getMoneyId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMoney(entity);
  }

  /*
   * @param	event AssignValueToMoneyEvent
   */
  @EventHandler(payloadType = AssignValueToMoneyEvent.class)
  public void handle(AssignValueToMoneyEvent event) {
    LOGGER.info("handling AssignValueToMoneyEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Money entity = assignValue(event.getMoneyId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMoney(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMoney(entity);
  }

  /*
   * @param	event UnAssignValueFromMoneyEvent
   */
  @EventHandler(payloadType = UnAssignValueFromMoneyEvent.class)
  public void handle(UnAssignValueFromMoneyEvent event) {
    LOGGER.info("handling UnAssignValueFromMoneyEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Money entity = unAssignValue(event.getMoneyId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMoney(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMoney(entity);
  }

  /**
   * Method to retrieve the Money via an MoneyPrimaryKey.
   *
   * @param id Long
   * @return Money
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Money handle(FindMoneyQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getMoneyId());
  }

  /**
   * Method to retrieve a collection of all Moneys
   *
   * @param query FindAllMoneyQuery
   * @return List<Money>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Money> handle(FindAllMoneyQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindMoney, but only if the id matches
   *
   * @param entity Money
   */
  protected void emitFindMoney(Money entity) {
    LOGGER.info("handling emitFindMoney");

    queryUpdateEmitter.emit(
        FindMoneyQuery.class,
        query -> query.getFilter().getMoneyId().equals(entity.getMoneyId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllMoney
   *
   * @param entity Money
   */
  protected void emitFindAllMoney(Money entity) {
    LOGGER.info("handling emitFindAllMoney");

    queryUpdateEmitter.emit(FindAllMoneyQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(MoneyProjector.class.getName());
}
