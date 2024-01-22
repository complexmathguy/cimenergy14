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
 * Projector for EnergyConsumer as outlined for the CQRS pattern. All event handling and query
 * handling related to EnergyConsumer are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by EnergyConsumerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("energyConsumer")
@Component("energyConsumer-projector")
public class EnergyConsumerProjector extends EnergyConsumerEntityProjector {

  // core constructor
  public EnergyConsumerProjector(
      EnergyConsumerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEnergyConsumerEvent
   */
  @EventHandler(payloadType = CreateEnergyConsumerEvent.class)
  public void handle(CreateEnergyConsumerEvent event) {
    LOGGER.info("handling CreateEnergyConsumerEvent - " + event);
    EnergyConsumer entity = new EnergyConsumer();
    entity.setEnergyConsumerId(event.getEnergyConsumerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event UpdateEnergyConsumerEvent
   */
  @EventHandler(payloadType = UpdateEnergyConsumerEvent.class)
  public void handle(UpdateEnergyConsumerEvent event) {
    LOGGER.info("handling UpdateEnergyConsumerEvent - " + event);

    EnergyConsumer entity = new EnergyConsumer();
    entity.setEnergyConsumerId(event.getEnergyConsumerId());
    entity.setPfixed(event.getPfixed());
    entity.setPfixedPct(event.getPfixedPct());
    entity.setQfixed(event.getQfixed());
    entity.setQfixedPct(event.getQfixedPct());
    entity.setEnergyConsumer(event.getEnergyConsumer());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event DeleteEnergyConsumerEvent
   */
  @EventHandler(payloadType = DeleteEnergyConsumerEvent.class)
  public void handle(DeleteEnergyConsumerEvent event) {
    LOGGER.info("handling DeleteEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EnergyConsumer entity = delete(event.getEnergyConsumerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event AssignPfixedToEnergyConsumerEvent
   */
  @EventHandler(payloadType = AssignPfixedToEnergyConsumerEvent.class)
  public void handle(AssignPfixedToEnergyConsumerEvent event) {
    LOGGER.info("handling AssignPfixedToEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EnergyConsumer entity = assignPfixed(event.getEnergyConsumerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event UnAssignPfixedFromEnergyConsumerEvent
   */
  @EventHandler(payloadType = UnAssignPfixedFromEnergyConsumerEvent.class)
  public void handle(UnAssignPfixedFromEnergyConsumerEvent event) {
    LOGGER.info("handling UnAssignPfixedFromEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EnergyConsumer entity = unAssignPfixed(event.getEnergyConsumerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event AssignPfixedPctToEnergyConsumerEvent
   */
  @EventHandler(payloadType = AssignPfixedPctToEnergyConsumerEvent.class)
  public void handle(AssignPfixedPctToEnergyConsumerEvent event) {
    LOGGER.info("handling AssignPfixedPctToEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EnergyConsumer entity = assignPfixedPct(event.getEnergyConsumerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event UnAssignPfixedPctFromEnergyConsumerEvent
   */
  @EventHandler(payloadType = UnAssignPfixedPctFromEnergyConsumerEvent.class)
  public void handle(UnAssignPfixedPctFromEnergyConsumerEvent event) {
    LOGGER.info("handling UnAssignPfixedPctFromEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EnergyConsumer entity = unAssignPfixedPct(event.getEnergyConsumerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event AssignQfixedToEnergyConsumerEvent
   */
  @EventHandler(payloadType = AssignQfixedToEnergyConsumerEvent.class)
  public void handle(AssignQfixedToEnergyConsumerEvent event) {
    LOGGER.info("handling AssignQfixedToEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EnergyConsumer entity = assignQfixed(event.getEnergyConsumerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event UnAssignQfixedFromEnergyConsumerEvent
   */
  @EventHandler(payloadType = UnAssignQfixedFromEnergyConsumerEvent.class)
  public void handle(UnAssignQfixedFromEnergyConsumerEvent event) {
    LOGGER.info("handling UnAssignQfixedFromEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EnergyConsumer entity = unAssignQfixed(event.getEnergyConsumerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event AssignQfixedPctToEnergyConsumerEvent
   */
  @EventHandler(payloadType = AssignQfixedPctToEnergyConsumerEvent.class)
  public void handle(AssignQfixedPctToEnergyConsumerEvent event) {
    LOGGER.info("handling AssignQfixedPctToEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EnergyConsumer entity = assignQfixedPct(event.getEnergyConsumerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event UnAssignQfixedPctFromEnergyConsumerEvent
   */
  @EventHandler(payloadType = UnAssignQfixedPctFromEnergyConsumerEvent.class)
  public void handle(UnAssignQfixedPctFromEnergyConsumerEvent event) {
    LOGGER.info("handling UnAssignQfixedPctFromEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EnergyConsumer entity = unAssignQfixedPct(event.getEnergyConsumerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event AssignEnergyConsumerToEnergyConsumerEvent
   */
  @EventHandler(payloadType = AssignEnergyConsumerToEnergyConsumerEvent.class)
  public void handle(AssignEnergyConsumerToEnergyConsumerEvent event) {
    LOGGER.info("handling AssignEnergyConsumerToEnergyConsumerEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    EnergyConsumer entity = addToEnergyConsumer(event.getEnergyConsumerId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /*
   * @param	event RemoveEnergyConsumerFromEnergyConsumerEvent
   */
  @EventHandler(payloadType = RemoveEnergyConsumerFromEnergyConsumerEvent.class)
  public void handle(RemoveEnergyConsumerFromEnergyConsumerEvent event) {
    LOGGER.info("handling RemoveEnergyConsumerFromEnergyConsumerEvent - " + event);

    EnergyConsumer entity =
        removeFromEnergyConsumer(event.getEnergyConsumerId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergyConsumer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergyConsumer(entity);
  }

  /**
   * Method to retrieve the EnergyConsumer via an EnergyConsumerPrimaryKey.
   *
   * @param id Long
   * @return EnergyConsumer
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EnergyConsumer handle(FindEnergyConsumerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEnergyConsumerId());
  }

  /**
   * Method to retrieve a collection of all EnergyConsumers
   *
   * @param query FindAllEnergyConsumerQuery
   * @return List<EnergyConsumer>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EnergyConsumer> handle(FindAllEnergyConsumerQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEnergyConsumer, but only if the id matches
   *
   * @param entity EnergyConsumer
   */
  protected void emitFindEnergyConsumer(EnergyConsumer entity) {
    LOGGER.info("handling emitFindEnergyConsumer");

    queryUpdateEmitter.emit(
        FindEnergyConsumerQuery.class,
        query -> query.getFilter().getEnergyConsumerId().equals(entity.getEnergyConsumerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEnergyConsumer
   *
   * @param entity EnergyConsumer
   */
  protected void emitFindAllEnergyConsumer(EnergyConsumer entity) {
    LOGGER.info("handling emitFindAllEnergyConsumer");

    queryUpdateEmitter.emit(FindAllEnergyConsumerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(EnergyConsumerProjector.class.getName());
}
