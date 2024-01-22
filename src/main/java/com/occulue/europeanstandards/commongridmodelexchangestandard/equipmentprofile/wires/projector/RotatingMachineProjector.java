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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RotatingMachine as outlined for the CQRS pattern. All event handling and query
 * handling related to RotatingMachine are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by RotatingMachineAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("rotatingMachine")
@Component("rotatingMachine-projector")
public class RotatingMachineProjector extends RotatingMachineEntityProjector {

  // core constructor
  public RotatingMachineProjector(
      RotatingMachineRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRotatingMachineEvent
   */
  @EventHandler(payloadType = CreateRotatingMachineEvent.class)
  public void handle(CreateRotatingMachineEvent event) {
    LOGGER.info("handling CreateRotatingMachineEvent - " + event);
    RotatingMachine entity = new RotatingMachine();
    entity.setRotatingMachineId(event.getRotatingMachineId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event UpdateRotatingMachineEvent
   */
  @EventHandler(payloadType = UpdateRotatingMachineEvent.class)
  public void handle(UpdateRotatingMachineEvent event) {
    LOGGER.info("handling UpdateRotatingMachineEvent - " + event);

    RotatingMachine entity = new RotatingMachine();
    entity.setRotatingMachineId(event.getRotatingMachineId());
    entity.setRatedPowerFactor(event.getRatedPowerFactor());
    entity.setRatedS(event.getRatedS());
    entity.setRatedU(event.getRatedU());
    entity.setRotatingMachine(event.getRotatingMachine());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event DeleteRotatingMachineEvent
   */
  @EventHandler(payloadType = DeleteRotatingMachineEvent.class)
  public void handle(DeleteRotatingMachineEvent event) {
    LOGGER.info("handling DeleteRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RotatingMachine entity = delete(event.getRotatingMachineId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event AssignRatedPowerFactorToRotatingMachineEvent
   */
  @EventHandler(payloadType = AssignRatedPowerFactorToRotatingMachineEvent.class)
  public void handle(AssignRatedPowerFactorToRotatingMachineEvent event) {
    LOGGER.info("handling AssignRatedPowerFactorToRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachine entity =
        assignRatedPowerFactor(event.getRotatingMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event UnAssignRatedPowerFactorFromRotatingMachineEvent
   */
  @EventHandler(payloadType = UnAssignRatedPowerFactorFromRotatingMachineEvent.class)
  public void handle(UnAssignRatedPowerFactorFromRotatingMachineEvent event) {
    LOGGER.info("handling UnAssignRatedPowerFactorFromRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachine entity = unAssignRatedPowerFactor(event.getRotatingMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event AssignRatedSToRotatingMachineEvent
   */
  @EventHandler(payloadType = AssignRatedSToRotatingMachineEvent.class)
  public void handle(AssignRatedSToRotatingMachineEvent event) {
    LOGGER.info("handling AssignRatedSToRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachine entity = assignRatedS(event.getRotatingMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event UnAssignRatedSFromRotatingMachineEvent
   */
  @EventHandler(payloadType = UnAssignRatedSFromRotatingMachineEvent.class)
  public void handle(UnAssignRatedSFromRotatingMachineEvent event) {
    LOGGER.info("handling UnAssignRatedSFromRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachine entity = unAssignRatedS(event.getRotatingMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event AssignRatedUToRotatingMachineEvent
   */
  @EventHandler(payloadType = AssignRatedUToRotatingMachineEvent.class)
  public void handle(AssignRatedUToRotatingMachineEvent event) {
    LOGGER.info("handling AssignRatedUToRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachine entity = assignRatedU(event.getRotatingMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event UnAssignRatedUFromRotatingMachineEvent
   */
  @EventHandler(payloadType = UnAssignRatedUFromRotatingMachineEvent.class)
  public void handle(UnAssignRatedUFromRotatingMachineEvent event) {
    LOGGER.info("handling UnAssignRatedUFromRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachine entity = unAssignRatedU(event.getRotatingMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event AssignRotatingMachineToRotatingMachineEvent
   */
  @EventHandler(payloadType = AssignRotatingMachineToRotatingMachineEvent.class)
  public void handle(AssignRotatingMachineToRotatingMachineEvent event) {
    LOGGER.info("handling AssignRotatingMachineToRotatingMachineEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    RotatingMachine entity = addToRotatingMachine(event.getRotatingMachineId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /*
   * @param	event RemoveRotatingMachineFromRotatingMachineEvent
   */
  @EventHandler(payloadType = RemoveRotatingMachineFromRotatingMachineEvent.class)
  public void handle(RemoveRotatingMachineFromRotatingMachineEvent event) {
    LOGGER.info("handling RemoveRotatingMachineFromRotatingMachineEvent - " + event);

    RotatingMachine entity =
        removeFromRotatingMachine(event.getRotatingMachineId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachine(entity);
  }

  /**
   * Method to retrieve the RotatingMachine via an RotatingMachinePrimaryKey.
   *
   * @param id Long
   * @return RotatingMachine
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RotatingMachine handle(FindRotatingMachineQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRotatingMachineId());
  }

  /**
   * Method to retrieve a collection of all RotatingMachines
   *
   * @param query FindAllRotatingMachineQuery
   * @return List<RotatingMachine>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RotatingMachine> handle(FindAllRotatingMachineQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRotatingMachine, but only if the id matches
   *
   * @param entity RotatingMachine
   */
  protected void emitFindRotatingMachine(RotatingMachine entity) {
    LOGGER.info("handling emitFindRotatingMachine");

    queryUpdateEmitter.emit(
        FindRotatingMachineQuery.class,
        query -> query.getFilter().getRotatingMachineId().equals(entity.getRotatingMachineId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRotatingMachine
   *
   * @param entity RotatingMachine
   */
  protected void emitFindAllRotatingMachine(RotatingMachine entity) {
    LOGGER.info("handling emitFindAllRotatingMachine");

    queryUpdateEmitter.emit(FindAllRotatingMachineQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(RotatingMachineProjector.class.getName());
}
