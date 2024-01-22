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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for AnalogValue as outlined for the CQRS pattern. All event handling and query handling
 * related to AnalogValue are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by AnalogValueAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("analogValue")
@Component("analogValue-projector")
public class AnalogValueProjector extends AnalogValueEntityProjector {

  // core constructor
  public AnalogValueProjector(
      AnalogValueRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAnalogValueEvent
   */
  @EventHandler(payloadType = CreateAnalogValueEvent.class)
  public void handle(CreateAnalogValueEvent event) {
    LOGGER.info("handling CreateAnalogValueEvent - " + event);
    AnalogValue entity = new AnalogValue();
    entity.setAnalogValueId(event.getAnalogValueId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /*
   * @param	event UpdateAnalogValueEvent
   */
  @EventHandler(payloadType = UpdateAnalogValueEvent.class)
  public void handle(UpdateAnalogValueEvent event) {
    LOGGER.info("handling UpdateAnalogValueEvent - " + event);

    AnalogValue entity = new AnalogValue();
    entity.setAnalogValueId(event.getAnalogValueId());
    entity.setValue(event.getValue());
    entity.setAnalogValues(event.getAnalogValues());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAnalogValue(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /*
   * @param	event DeleteAnalogValueEvent
   */
  @EventHandler(payloadType = DeleteAnalogValueEvent.class)
  public void handle(DeleteAnalogValueEvent event) {
    LOGGER.info("handling DeleteAnalogValueEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AnalogValue entity = delete(event.getAnalogValueId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /*
   * @param	event AssignValueToAnalogValueEvent
   */
  @EventHandler(payloadType = AssignValueToAnalogValueEvent.class)
  public void handle(AssignValueToAnalogValueEvent event) {
    LOGGER.info("handling AssignValueToAnalogValueEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AnalogValue entity = assignValue(event.getAnalogValueId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAnalogValue(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /*
   * @param	event UnAssignValueFromAnalogValueEvent
   */
  @EventHandler(payloadType = UnAssignValueFromAnalogValueEvent.class)
  public void handle(UnAssignValueFromAnalogValueEvent event) {
    LOGGER.info("handling UnAssignValueFromAnalogValueEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AnalogValue entity = unAssignValue(event.getAnalogValueId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAnalogValue(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /*
   * @param	event AssignAnalogValuesToAnalogValueEvent
   */
  @EventHandler(payloadType = AssignAnalogValuesToAnalogValueEvent.class)
  public void handle(AssignAnalogValuesToAnalogValueEvent event) {
    LOGGER.info("handling AssignAnalogValuesToAnalogValueEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    AnalogValue entity = addToAnalogValues(event.getAnalogValueId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAnalogValue(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /*
   * @param	event RemoveAnalogValuesFromAnalogValueEvent
   */
  @EventHandler(payloadType = RemoveAnalogValuesFromAnalogValueEvent.class)
  public void handle(RemoveAnalogValuesFromAnalogValueEvent event) {
    LOGGER.info("handling RemoveAnalogValuesFromAnalogValueEvent - " + event);

    AnalogValue entity = removeFromAnalogValues(event.getAnalogValueId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAnalogValue(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAnalogValue(entity);
  }

  /**
   * Method to retrieve the AnalogValue via an AnalogValuePrimaryKey.
   *
   * @param id Long
   * @return AnalogValue
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AnalogValue handle(FindAnalogValueQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAnalogValueId());
  }

  /**
   * Method to retrieve a collection of all AnalogValues
   *
   * @param query FindAllAnalogValueQuery
   * @return List<AnalogValue>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AnalogValue> handle(FindAllAnalogValueQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAnalogValue, but only if the id matches
   *
   * @param entity AnalogValue
   */
  protected void emitFindAnalogValue(AnalogValue entity) {
    LOGGER.info("handling emitFindAnalogValue");

    queryUpdateEmitter.emit(
        FindAnalogValueQuery.class,
        query -> query.getFilter().getAnalogValueId().equals(entity.getAnalogValueId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllAnalogValue
   *
   * @param entity AnalogValue
   */
  protected void emitFindAllAnalogValue(AnalogValue entity) {
    LOGGER.info("handling emitFindAllAnalogValue");

    queryUpdateEmitter.emit(FindAllAnalogValueQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(AnalogValueProjector.class.getName());
}
