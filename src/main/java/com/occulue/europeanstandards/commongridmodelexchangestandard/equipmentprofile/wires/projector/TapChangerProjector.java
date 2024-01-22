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
 * Projector for TapChanger as outlined for the CQRS pattern. All event handling and query handling
 * related to TapChanger are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by TapChangerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("tapChanger")
@Component("tapChanger-projector")
public class TapChangerProjector extends TapChangerEntityProjector {

  // core constructor
  public TapChangerProjector(
      TapChangerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTapChangerEvent
   */
  @EventHandler(payloadType = CreateTapChangerEvent.class)
  public void handle(CreateTapChangerEvent event) {
    LOGGER.info("handling CreateTapChangerEvent - " + event);
    TapChanger entity = new TapChanger();
    entity.setTapChangerId(event.getTapChangerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UpdateTapChangerEvent
   */
  @EventHandler(payloadType = UpdateTapChangerEvent.class)
  public void handle(UpdateTapChangerEvent event) {
    LOGGER.info("handling UpdateTapChangerEvent - " + event);

    TapChanger entity = new TapChanger();
    entity.setTapChangerId(event.getTapChangerId());
    entity.setHighStep(event.getHighStep());
    entity.setLowStep(event.getLowStep());
    entity.setLtcFlag(event.getLtcFlag());
    entity.setNeutralStep(event.getNeutralStep());
    entity.setNeutralU(event.getNeutralU());
    entity.setNormalStep(event.getNormalStep());
    entity.setTapChanger(event.getTapChanger());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event DeleteTapChangerEvent
   */
  @EventHandler(payloadType = DeleteTapChangerEvent.class)
  public void handle(DeleteTapChangerEvent event) {
    LOGGER.info("handling DeleteTapChangerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TapChanger entity = delete(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignHighStepToTapChangerEvent
   */
  @EventHandler(payloadType = AssignHighStepToTapChangerEvent.class)
  public void handle(AssignHighStepToTapChangerEvent event) {
    LOGGER.info("handling AssignHighStepToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChanger entity = assignHighStep(event.getTapChangerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UnAssignHighStepFromTapChangerEvent
   */
  @EventHandler(payloadType = UnAssignHighStepFromTapChangerEvent.class)
  public void handle(UnAssignHighStepFromTapChangerEvent event) {
    LOGGER.info("handling UnAssignHighStepFromTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChanger entity = unAssignHighStep(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignLowStepToTapChangerEvent
   */
  @EventHandler(payloadType = AssignLowStepToTapChangerEvent.class)
  public void handle(AssignLowStepToTapChangerEvent event) {
    LOGGER.info("handling AssignLowStepToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChanger entity = assignLowStep(event.getTapChangerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UnAssignLowStepFromTapChangerEvent
   */
  @EventHandler(payloadType = UnAssignLowStepFromTapChangerEvent.class)
  public void handle(UnAssignLowStepFromTapChangerEvent event) {
    LOGGER.info("handling UnAssignLowStepFromTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChanger entity = unAssignLowStep(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignLtcFlagToTapChangerEvent
   */
  @EventHandler(payloadType = AssignLtcFlagToTapChangerEvent.class)
  public void handle(AssignLtcFlagToTapChangerEvent event) {
    LOGGER.info("handling AssignLtcFlagToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChanger entity = assignLtcFlag(event.getTapChangerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UnAssignLtcFlagFromTapChangerEvent
   */
  @EventHandler(payloadType = UnAssignLtcFlagFromTapChangerEvent.class)
  public void handle(UnAssignLtcFlagFromTapChangerEvent event) {
    LOGGER.info("handling UnAssignLtcFlagFromTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChanger entity = unAssignLtcFlag(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignNeutralStepToTapChangerEvent
   */
  @EventHandler(payloadType = AssignNeutralStepToTapChangerEvent.class)
  public void handle(AssignNeutralStepToTapChangerEvent event) {
    LOGGER.info("handling AssignNeutralStepToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChanger entity = assignNeutralStep(event.getTapChangerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UnAssignNeutralStepFromTapChangerEvent
   */
  @EventHandler(payloadType = UnAssignNeutralStepFromTapChangerEvent.class)
  public void handle(UnAssignNeutralStepFromTapChangerEvent event) {
    LOGGER.info("handling UnAssignNeutralStepFromTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChanger entity = unAssignNeutralStep(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignNeutralUToTapChangerEvent
   */
  @EventHandler(payloadType = AssignNeutralUToTapChangerEvent.class)
  public void handle(AssignNeutralUToTapChangerEvent event) {
    LOGGER.info("handling AssignNeutralUToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChanger entity = assignNeutralU(event.getTapChangerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UnAssignNeutralUFromTapChangerEvent
   */
  @EventHandler(payloadType = UnAssignNeutralUFromTapChangerEvent.class)
  public void handle(UnAssignNeutralUFromTapChangerEvent event) {
    LOGGER.info("handling UnAssignNeutralUFromTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChanger entity = unAssignNeutralU(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignNormalStepToTapChangerEvent
   */
  @EventHandler(payloadType = AssignNormalStepToTapChangerEvent.class)
  public void handle(AssignNormalStepToTapChangerEvent event) {
    LOGGER.info("handling AssignNormalStepToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChanger entity = assignNormalStep(event.getTapChangerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event UnAssignNormalStepFromTapChangerEvent
   */
  @EventHandler(payloadType = UnAssignNormalStepFromTapChangerEvent.class)
  public void handle(UnAssignNormalStepFromTapChangerEvent event) {
    LOGGER.info("handling UnAssignNormalStepFromTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChanger entity = unAssignNormalStep(event.getTapChangerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event AssignTapChangerToTapChangerEvent
   */
  @EventHandler(payloadType = AssignTapChangerToTapChangerEvent.class)
  public void handle(AssignTapChangerToTapChangerEvent event) {
    LOGGER.info("handling AssignTapChangerToTapChangerEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    TapChanger entity = addToTapChanger(event.getTapChangerId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /*
   * @param	event RemoveTapChangerFromTapChangerEvent
   */
  @EventHandler(payloadType = RemoveTapChangerFromTapChangerEvent.class)
  public void handle(RemoveTapChangerFromTapChangerEvent event) {
    LOGGER.info("handling RemoveTapChangerFromTapChangerEvent - " + event);

    TapChanger entity = removeFromTapChanger(event.getTapChangerId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChanger(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChanger(entity);
  }

  /**
   * Method to retrieve the TapChanger via an TapChangerPrimaryKey.
   *
   * @param id Long
   * @return TapChanger
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TapChanger handle(FindTapChangerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTapChangerId());
  }

  /**
   * Method to retrieve a collection of all TapChangers
   *
   * @param query FindAllTapChangerQuery
   * @return List<TapChanger>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TapChanger> handle(FindAllTapChangerQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTapChanger, but only if the id matches
   *
   * @param entity TapChanger
   */
  protected void emitFindTapChanger(TapChanger entity) {
    LOGGER.info("handling emitFindTapChanger");

    queryUpdateEmitter.emit(
        FindTapChangerQuery.class,
        query -> query.getFilter().getTapChangerId().equals(entity.getTapChangerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTapChanger
   *
   * @param entity TapChanger
   */
  protected void emitFindAllTapChanger(TapChanger entity) {
    LOGGER.info("handling emitFindAllTapChanger");

    queryUpdateEmitter.emit(FindAllTapChangerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(TapChangerProjector.class.getName());
}
