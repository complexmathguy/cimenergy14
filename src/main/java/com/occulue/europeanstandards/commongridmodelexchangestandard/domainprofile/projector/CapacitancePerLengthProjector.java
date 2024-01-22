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
 * Projector for CapacitancePerLength as outlined for the CQRS pattern. All event handling and query
 * handling related to CapacitancePerLength are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by CapacitancePerLengthAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("capacitancePerLength")
@Component("capacitancePerLength-projector")
public class CapacitancePerLengthProjector extends CapacitancePerLengthEntityProjector {

  // core constructor
  public CapacitancePerLengthProjector(
      CapacitancePerLengthRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateCapacitancePerLengthEvent
   */
  @EventHandler(payloadType = CreateCapacitancePerLengthEvent.class)
  public void handle(CreateCapacitancePerLengthEvent event) {
    LOGGER.info("handling CreateCapacitancePerLengthEvent - " + event);
    CapacitancePerLength entity = new CapacitancePerLength();
    entity.setCapacitancePerLengthId(event.getCapacitancePerLengthId());
    entity.setDenominatorMultiplier(event.getDenominatorMultiplier());
    entity.setDenominatorUnit(event.getDenominatorUnit());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitancePerLength(entity);
  }

  /*
   * @param	event UpdateCapacitancePerLengthEvent
   */
  @EventHandler(payloadType = UpdateCapacitancePerLengthEvent.class)
  public void handle(UpdateCapacitancePerLengthEvent event) {
    LOGGER.info("handling UpdateCapacitancePerLengthEvent - " + event);

    CapacitancePerLength entity = new CapacitancePerLength();
    entity.setCapacitancePerLengthId(event.getCapacitancePerLengthId());
    entity.setDenominatorMultiplier(event.getDenominatorMultiplier());
    entity.setDenominatorUnit(event.getDenominatorUnit());
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
    emitFindCapacitancePerLength(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitancePerLength(entity);
  }

  /*
   * @param	event DeleteCapacitancePerLengthEvent
   */
  @EventHandler(payloadType = DeleteCapacitancePerLengthEvent.class)
  public void handle(DeleteCapacitancePerLengthEvent event) {
    LOGGER.info("handling DeleteCapacitancePerLengthEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    CapacitancePerLength entity = delete(event.getCapacitancePerLengthId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitancePerLength(entity);
  }

  /*
   * @param	event AssignValueToCapacitancePerLengthEvent
   */
  @EventHandler(payloadType = AssignValueToCapacitancePerLengthEvent.class)
  public void handle(AssignValueToCapacitancePerLengthEvent event) {
    LOGGER.info("handling AssignValueToCapacitancePerLengthEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CapacitancePerLength entity =
        assignValue(event.getCapacitancePerLengthId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCapacitancePerLength(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitancePerLength(entity);
  }

  /*
   * @param	event UnAssignValueFromCapacitancePerLengthEvent
   */
  @EventHandler(payloadType = UnAssignValueFromCapacitancePerLengthEvent.class)
  public void handle(UnAssignValueFromCapacitancePerLengthEvent event) {
    LOGGER.info("handling UnAssignValueFromCapacitancePerLengthEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CapacitancePerLength entity = unAssignValue(event.getCapacitancePerLengthId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCapacitancePerLength(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitancePerLength(entity);
  }

  /**
   * Method to retrieve the CapacitancePerLength via an CapacitancePerLengthPrimaryKey.
   *
   * @param id Long
   * @return CapacitancePerLength
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public CapacitancePerLength handle(FindCapacitancePerLengthQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getCapacitancePerLengthId());
  }

  /**
   * Method to retrieve a collection of all CapacitancePerLengths
   *
   * @param query FindAllCapacitancePerLengthQuery
   * @return List<CapacitancePerLength>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<CapacitancePerLength> handle(FindAllCapacitancePerLengthQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindCapacitancePerLength, but only if the id matches
   *
   * @param entity CapacitancePerLength
   */
  protected void emitFindCapacitancePerLength(CapacitancePerLength entity) {
    LOGGER.info("handling emitFindCapacitancePerLength");

    queryUpdateEmitter.emit(
        FindCapacitancePerLengthQuery.class,
        query ->
            query
                .getFilter()
                .getCapacitancePerLengthId()
                .equals(entity.getCapacitancePerLengthId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllCapacitancePerLength
   *
   * @param entity CapacitancePerLength
   */
  protected void emitFindAllCapacitancePerLength(CapacitancePerLength entity) {
    LOGGER.info("handling emitFindAllCapacitancePerLength");

    queryUpdateEmitter.emit(FindAllCapacitancePerLengthQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(CapacitancePerLengthProjector.class.getName());
}
