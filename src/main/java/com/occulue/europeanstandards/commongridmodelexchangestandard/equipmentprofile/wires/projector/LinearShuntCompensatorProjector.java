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
 * Projector for LinearShuntCompensator as outlined for the CQRS pattern. All event handling and
 * query handling related to LinearShuntCompensator are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by LinearShuntCompensatorAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("linearShuntCompensator")
@Component("linearShuntCompensator-projector")
public class LinearShuntCompensatorProjector extends LinearShuntCompensatorEntityProjector {

  // core constructor
  public LinearShuntCompensatorProjector(
      LinearShuntCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = CreateLinearShuntCompensatorEvent.class)
  public void handle(CreateLinearShuntCompensatorEvent event) {
    LOGGER.info("handling CreateLinearShuntCompensatorEvent - " + event);
    LinearShuntCompensator entity = new LinearShuntCompensator();
    entity.setLinearShuntCompensatorId(event.getLinearShuntCompensatorId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event UpdateLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = UpdateLinearShuntCompensatorEvent.class)
  public void handle(UpdateLinearShuntCompensatorEvent event) {
    LOGGER.info("handling UpdateLinearShuntCompensatorEvent - " + event);

    LinearShuntCompensator entity = new LinearShuntCompensator();
    entity.setLinearShuntCompensatorId(event.getLinearShuntCompensatorId());
    entity.setB0PerSection(event.getB0PerSection());
    entity.setBPerSection(event.getBPerSection());
    entity.setG0PerSection(event.getG0PerSection());
    entity.setGPerSection(event.getGPerSection());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event DeleteLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = DeleteLinearShuntCompensatorEvent.class)
  public void handle(DeleteLinearShuntCompensatorEvent event) {
    LOGGER.info("handling DeleteLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    LinearShuntCompensator entity = delete(event.getLinearShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event AssignB0PerSectionToLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignB0PerSectionToLinearShuntCompensatorEvent.class)
  public void handle(AssignB0PerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("handling AssignB0PerSectionToLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LinearShuntCompensator entity =
        assignB0PerSection(event.getLinearShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignB0PerSectionFromLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignB0PerSectionFromLinearShuntCompensatorEvent.class)
  public void handle(UnAssignB0PerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignB0PerSectionFromLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LinearShuntCompensator entity = unAssignB0PerSection(event.getLinearShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event AssignBPerSectionToLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignBPerSectionToLinearShuntCompensatorEvent.class)
  public void handle(AssignBPerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("handling AssignBPerSectionToLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LinearShuntCompensator entity =
        assignBPerSection(event.getLinearShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignBPerSectionFromLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignBPerSectionFromLinearShuntCompensatorEvent.class)
  public void handle(UnAssignBPerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignBPerSectionFromLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LinearShuntCompensator entity = unAssignBPerSection(event.getLinearShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event AssignG0PerSectionToLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignG0PerSectionToLinearShuntCompensatorEvent.class)
  public void handle(AssignG0PerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("handling AssignG0PerSectionToLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LinearShuntCompensator entity =
        assignG0PerSection(event.getLinearShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignG0PerSectionFromLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignG0PerSectionFromLinearShuntCompensatorEvent.class)
  public void handle(UnAssignG0PerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignG0PerSectionFromLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LinearShuntCompensator entity = unAssignG0PerSection(event.getLinearShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event AssignGPerSectionToLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignGPerSectionToLinearShuntCompensatorEvent.class)
  public void handle(AssignGPerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("handling AssignGPerSectionToLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LinearShuntCompensator entity =
        assignGPerSection(event.getLinearShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignGPerSectionFromLinearShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignGPerSectionFromLinearShuntCompensatorEvent.class)
  public void handle(UnAssignGPerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignGPerSectionFromLinearShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LinearShuntCompensator entity = unAssignGPerSection(event.getLinearShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLinearShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLinearShuntCompensator(entity);
  }

  /**
   * Method to retrieve the LinearShuntCompensator via an LinearShuntCompensatorPrimaryKey.
   *
   * @param id Long
   * @return LinearShuntCompensator
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public LinearShuntCompensator handle(FindLinearShuntCompensatorQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLinearShuntCompensatorId());
  }

  /**
   * Method to retrieve a collection of all LinearShuntCompensators
   *
   * @param query FindAllLinearShuntCompensatorQuery
   * @return List<LinearShuntCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<LinearShuntCompensator> handle(FindAllLinearShuntCompensatorQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLinearShuntCompensator, but only if the id matches
   *
   * @param entity LinearShuntCompensator
   */
  protected void emitFindLinearShuntCompensator(LinearShuntCompensator entity) {
    LOGGER.info("handling emitFindLinearShuntCompensator");

    queryUpdateEmitter.emit(
        FindLinearShuntCompensatorQuery.class,
        query ->
            query
                .getFilter()
                .getLinearShuntCompensatorId()
                .equals(entity.getLinearShuntCompensatorId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLinearShuntCompensator
   *
   * @param entity LinearShuntCompensator
   */
  protected void emitFindAllLinearShuntCompensator(LinearShuntCompensator entity) {
    LOGGER.info("handling emitFindAllLinearShuntCompensator");

    queryUpdateEmitter.emit(FindAllLinearShuntCompensatorQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(LinearShuntCompensatorProjector.class.getName());
}
