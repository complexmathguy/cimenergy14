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
 * Projector for ShuntCompensator as outlined for the CQRS pattern. All event handling and query
 * handling related to ShuntCompensator are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ShuntCompensatorAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("shuntCompensator")
@Component("shuntCompensator-projector")
public class ShuntCompensatorProjector extends ShuntCompensatorEntityProjector {

  // core constructor
  public ShuntCompensatorProjector(
      ShuntCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateShuntCompensatorEvent
   */
  @EventHandler(payloadType = CreateShuntCompensatorEvent.class)
  public void handle(CreateShuntCompensatorEvent event) {
    LOGGER.info("handling CreateShuntCompensatorEvent - " + event);
    ShuntCompensator entity = new ShuntCompensator();
    entity.setShuntCompensatorId(event.getShuntCompensatorId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UpdateShuntCompensatorEvent
   */
  @EventHandler(payloadType = UpdateShuntCompensatorEvent.class)
  public void handle(UpdateShuntCompensatorEvent event) {
    LOGGER.info("handling UpdateShuntCompensatorEvent - " + event);

    ShuntCompensator entity = new ShuntCompensator();
    entity.setShuntCompensatorId(event.getShuntCompensatorId());
    entity.setAVRDelay(event.getAVRDelay());
    entity.setGrounded(event.getGrounded());
    entity.setMaximumSections(event.getMaximumSections());
    entity.setNomU(event.getNomU());
    entity.setNormalSections(event.getNormalSections());
    entity.setSwitchOnCount(event.getSwitchOnCount());
    entity.setSwitchOnDate(event.getSwitchOnDate());
    entity.setVoltageSensitivity(event.getVoltageSensitivity());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event DeleteShuntCompensatorEvent
   */
  @EventHandler(payloadType = DeleteShuntCompensatorEvent.class)
  public void handle(DeleteShuntCompensatorEvent event) {
    LOGGER.info("handling DeleteShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ShuntCompensator entity = delete(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignAVRDelayToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignAVRDelayToShuntCompensatorEvent.class)
  public void handle(AssignAVRDelayToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignAVRDelayToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity = assignAVRDelay(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignAVRDelayFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignAVRDelayFromShuntCompensatorEvent.class)
  public void handle(UnAssignAVRDelayFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignAVRDelayFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignAVRDelay(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignGroundedToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignGroundedToShuntCompensatorEvent.class)
  public void handle(AssignGroundedToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignGroundedToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity = assignGrounded(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignGroundedFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignGroundedFromShuntCompensatorEvent.class)
  public void handle(UnAssignGroundedFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignGroundedFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignGrounded(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignMaximumSectionsToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignMaximumSectionsToShuntCompensatorEvent.class)
  public void handle(AssignMaximumSectionsToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignMaximumSectionsToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity =
        assignMaximumSections(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignMaximumSectionsFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignMaximumSectionsFromShuntCompensatorEvent.class)
  public void handle(UnAssignMaximumSectionsFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignMaximumSectionsFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignMaximumSections(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignNomUToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignNomUToShuntCompensatorEvent.class)
  public void handle(AssignNomUToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignNomUToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity = assignNomU(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignNomUFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignNomUFromShuntCompensatorEvent.class)
  public void handle(UnAssignNomUFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignNomUFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignNomU(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignNormalSectionsToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignNormalSectionsToShuntCompensatorEvent.class)
  public void handle(AssignNormalSectionsToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignNormalSectionsToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity =
        assignNormalSections(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignNormalSectionsFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignNormalSectionsFromShuntCompensatorEvent.class)
  public void handle(UnAssignNormalSectionsFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignNormalSectionsFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignNormalSections(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignSwitchOnCountToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignSwitchOnCountToShuntCompensatorEvent.class)
  public void handle(AssignSwitchOnCountToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignSwitchOnCountToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity =
        assignSwitchOnCount(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignSwitchOnCountFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignSwitchOnCountFromShuntCompensatorEvent.class)
  public void handle(UnAssignSwitchOnCountFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignSwitchOnCountFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignSwitchOnCount(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignSwitchOnDateToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignSwitchOnDateToShuntCompensatorEvent.class)
  public void handle(AssignSwitchOnDateToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignSwitchOnDateToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity =
        assignSwitchOnDate(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignSwitchOnDateFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignSwitchOnDateFromShuntCompensatorEvent.class)
  public void handle(UnAssignSwitchOnDateFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignSwitchOnDateFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignSwitchOnDate(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event AssignVoltageSensitivityToShuntCompensatorEvent
   */
  @EventHandler(payloadType = AssignVoltageSensitivityToShuntCompensatorEvent.class)
  public void handle(AssignVoltageSensitivityToShuntCompensatorEvent event) {
    LOGGER.info("handling AssignVoltageSensitivityToShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ShuntCompensator entity =
        assignVoltageSensitivity(event.getShuntCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /*
   * @param	event UnAssignVoltageSensitivityFromShuntCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignVoltageSensitivityFromShuntCompensatorEvent.class)
  public void handle(UnAssignVoltageSensitivityFromShuntCompensatorEvent event) {
    LOGGER.info("handling UnAssignVoltageSensitivityFromShuntCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ShuntCompensator entity = unAssignVoltageSensitivity(event.getShuntCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindShuntCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllShuntCompensator(entity);
  }

  /**
   * Method to retrieve the ShuntCompensator via an ShuntCompensatorPrimaryKey.
   *
   * @param id Long
   * @return ShuntCompensator
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ShuntCompensator handle(FindShuntCompensatorQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getShuntCompensatorId());
  }

  /**
   * Method to retrieve a collection of all ShuntCompensators
   *
   * @param query FindAllShuntCompensatorQuery
   * @return List<ShuntCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ShuntCompensator> handle(FindAllShuntCompensatorQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindShuntCompensator, but only if the id matches
   *
   * @param entity ShuntCompensator
   */
  protected void emitFindShuntCompensator(ShuntCompensator entity) {
    LOGGER.info("handling emitFindShuntCompensator");

    queryUpdateEmitter.emit(
        FindShuntCompensatorQuery.class,
        query -> query.getFilter().getShuntCompensatorId().equals(entity.getShuntCompensatorId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllShuntCompensator
   *
   * @param entity ShuntCompensator
   */
  protected void emitFindAllShuntCompensator(ShuntCompensator entity) {
    LOGGER.info("handling emitFindAllShuntCompensator");

    queryUpdateEmitter.emit(FindAllShuntCompensatorQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ShuntCompensatorProjector.class.getName());
}
