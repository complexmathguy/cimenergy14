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
 * Projector for TapChangerTablePoint as outlined for the CQRS pattern. All event handling and query
 * handling related to TapChangerTablePoint are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by TapChangerTablePointAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("tapChangerTablePoint")
@Component("tapChangerTablePoint-projector")
public class TapChangerTablePointProjector extends TapChangerTablePointEntityProjector {

  // core constructor
  public TapChangerTablePointProjector(
      TapChangerTablePointRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTapChangerTablePointEvent
   */
  @EventHandler(payloadType = CreateTapChangerTablePointEvent.class)
  public void handle(CreateTapChangerTablePointEvent event) {
    LOGGER.info("handling CreateTapChangerTablePointEvent - " + event);
    TapChangerTablePoint entity = new TapChangerTablePoint();
    entity.setTapChangerTablePointId(event.getTapChangerTablePointId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UpdateTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UpdateTapChangerTablePointEvent.class)
  public void handle(UpdateTapChangerTablePointEvent event) {
    LOGGER.info("handling UpdateTapChangerTablePointEvent - " + event);

    TapChangerTablePoint entity = new TapChangerTablePoint();
    entity.setTapChangerTablePointId(event.getTapChangerTablePointId());
    entity.setB(event.getB());
    entity.setG(event.getG());
    entity.setR(event.getR());
    entity.setRatio(event.getRatio());
    entity.setStep(event.getStep());
    entity.setX(event.getX());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event DeleteTapChangerTablePointEvent
   */
  @EventHandler(payloadType = DeleteTapChangerTablePointEvent.class)
  public void handle(DeleteTapChangerTablePointEvent event) {
    LOGGER.info("handling DeleteTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TapChangerTablePoint entity = delete(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignBToTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignBToTapChangerTablePointEvent.class)
  public void handle(AssignBToTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignBToTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChangerTablePoint entity = assignB(event.getTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignBFromTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignBFromTapChangerTablePointEvent.class)
  public void handle(UnAssignBFromTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignBFromTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChangerTablePoint entity = unAssignB(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignGToTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignGToTapChangerTablePointEvent.class)
  public void handle(AssignGToTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignGToTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChangerTablePoint entity = assignG(event.getTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignGFromTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignGFromTapChangerTablePointEvent.class)
  public void handle(UnAssignGFromTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignGFromTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChangerTablePoint entity = unAssignG(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignRToTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignRToTapChangerTablePointEvent.class)
  public void handle(AssignRToTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignRToTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChangerTablePoint entity = assignR(event.getTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignRFromTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignRFromTapChangerTablePointEvent.class)
  public void handle(UnAssignRFromTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignRFromTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChangerTablePoint entity = unAssignR(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignRatioToTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignRatioToTapChangerTablePointEvent.class)
  public void handle(AssignRatioToTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignRatioToTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChangerTablePoint entity =
        assignRatio(event.getTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignRatioFromTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignRatioFromTapChangerTablePointEvent.class)
  public void handle(UnAssignRatioFromTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignRatioFromTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChangerTablePoint entity = unAssignRatio(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignStepToTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignStepToTapChangerTablePointEvent.class)
  public void handle(AssignStepToTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignStepToTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChangerTablePoint entity =
        assignStep(event.getTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignStepFromTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignStepFromTapChangerTablePointEvent.class)
  public void handle(UnAssignStepFromTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignStepFromTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChangerTablePoint entity = unAssignStep(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignXToTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignXToTapChangerTablePointEvent.class)
  public void handle(AssignXToTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignXToTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TapChangerTablePoint entity = assignX(event.getTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignXFromTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignXFromTapChangerTablePointEvent.class)
  public void handle(UnAssignXFromTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignXFromTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TapChangerTablePoint entity = unAssignX(event.getTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTapChangerTablePoint(entity);
  }

  /**
   * Method to retrieve the TapChangerTablePoint via an TapChangerTablePointPrimaryKey.
   *
   * @param id Long
   * @return TapChangerTablePoint
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TapChangerTablePoint handle(FindTapChangerTablePointQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTapChangerTablePointId());
  }

  /**
   * Method to retrieve a collection of all TapChangerTablePoints
   *
   * @param query FindAllTapChangerTablePointQuery
   * @return List<TapChangerTablePoint>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TapChangerTablePoint> handle(FindAllTapChangerTablePointQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTapChangerTablePoint, but only if the id matches
   *
   * @param entity TapChangerTablePoint
   */
  protected void emitFindTapChangerTablePoint(TapChangerTablePoint entity) {
    LOGGER.info("handling emitFindTapChangerTablePoint");

    queryUpdateEmitter.emit(
        FindTapChangerTablePointQuery.class,
        query ->
            query
                .getFilter()
                .getTapChangerTablePointId()
                .equals(entity.getTapChangerTablePointId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTapChangerTablePoint
   *
   * @param entity TapChangerTablePoint
   */
  protected void emitFindAllTapChangerTablePoint(TapChangerTablePoint entity) {
    LOGGER.info("handling emitFindAllTapChangerTablePoint");

    queryUpdateEmitter.emit(FindAllTapChangerTablePointQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(TapChangerTablePointProjector.class.getName());
}
