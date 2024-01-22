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
 * Projector for PhaseTapChangerTablePoint as outlined for the CQRS pattern. All event handling and
 * query handling related to PhaseTapChangerTablePoint are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by PhaseTapChangerTablePointAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("phaseTapChangerTablePoint")
@Component("phaseTapChangerTablePoint-projector")
public class PhaseTapChangerTablePointProjector extends PhaseTapChangerTablePointEntityProjector {

  // core constructor
  public PhaseTapChangerTablePointProjector(
      PhaseTapChangerTablePointRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePhaseTapChangerTablePointEvent
   */
  @EventHandler(payloadType = CreatePhaseTapChangerTablePointEvent.class)
  public void handle(CreatePhaseTapChangerTablePointEvent event) {
    LOGGER.info("handling CreatePhaseTapChangerTablePointEvent - " + event);
    PhaseTapChangerTablePoint entity = new PhaseTapChangerTablePoint();
    entity.setPhaseTapChangerTablePointId(event.getPhaseTapChangerTablePointId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /*
   * @param	event UpdatePhaseTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UpdatePhaseTapChangerTablePointEvent.class)
  public void handle(UpdatePhaseTapChangerTablePointEvent event) {
    LOGGER.info("handling UpdatePhaseTapChangerTablePointEvent - " + event);

    PhaseTapChangerTablePoint entity = new PhaseTapChangerTablePoint();
    entity.setPhaseTapChangerTablePointId(event.getPhaseTapChangerTablePointId());
    entity.setAngle(event.getAngle());
    entity.setPhaseTapChangerTablePoint(event.getPhaseTapChangerTablePoint());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /*
   * @param	event DeletePhaseTapChangerTablePointEvent
   */
  @EventHandler(payloadType = DeletePhaseTapChangerTablePointEvent.class)
  public void handle(DeletePhaseTapChangerTablePointEvent event) {
    LOGGER.info("handling DeletePhaseTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PhaseTapChangerTablePoint entity = delete(event.getPhaseTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignAngleToPhaseTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignAngleToPhaseTapChangerTablePointEvent.class)
  public void handle(AssignAngleToPhaseTapChangerTablePointEvent event) {
    LOGGER.info("handling AssignAngleToPhaseTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PhaseTapChangerTablePoint entity =
        assignAngle(event.getPhaseTapChangerTablePointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /*
   * @param	event UnAssignAngleFromPhaseTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UnAssignAngleFromPhaseTapChangerTablePointEvent.class)
  public void handle(UnAssignAngleFromPhaseTapChangerTablePointEvent event) {
    LOGGER.info("handling UnAssignAngleFromPhaseTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PhaseTapChangerTablePoint entity = unAssignAngle(event.getPhaseTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent.class)
  public void handle(AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent event) {
    LOGGER.info(
        "handling AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    PhaseTapChangerTablePoint entity =
        addToPhaseTapChangerTablePoint(event.getPhaseTapChangerTablePointId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /*
   * @param	event RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent
   */
  @EventHandler(
      payloadType = RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent.class)
  public void handle(RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent event) {
    LOGGER.info(
        "handling RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent - " + event);

    PhaseTapChangerTablePoint entity =
        removeFromPhaseTapChangerTablePoint(
            event.getPhaseTapChangerTablePointId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerTablePoint(entity);
  }

  /**
   * Method to retrieve the PhaseTapChangerTablePoint via an PhaseTapChangerTablePointPrimaryKey.
   *
   * @param id Long
   * @return PhaseTapChangerTablePoint
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PhaseTapChangerTablePoint handle(FindPhaseTapChangerTablePointQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPhaseTapChangerTablePointId());
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerTablePoints
   *
   * @param query FindAllPhaseTapChangerTablePointQuery
   * @return List<PhaseTapChangerTablePoint>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PhaseTapChangerTablePoint> handle(FindAllPhaseTapChangerTablePointQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPhaseTapChangerTablePoint, but only if the id matches
   *
   * @param entity PhaseTapChangerTablePoint
   */
  protected void emitFindPhaseTapChangerTablePoint(PhaseTapChangerTablePoint entity) {
    LOGGER.info("handling emitFindPhaseTapChangerTablePoint");

    queryUpdateEmitter.emit(
        FindPhaseTapChangerTablePointQuery.class,
        query ->
            query
                .getFilter()
                .getPhaseTapChangerTablePointId()
                .equals(entity.getPhaseTapChangerTablePointId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPhaseTapChangerTablePoint
   *
   * @param entity PhaseTapChangerTablePoint
   */
  protected void emitFindAllPhaseTapChangerTablePoint(PhaseTapChangerTablePoint entity) {
    LOGGER.info("handling emitFindAllPhaseTapChangerTablePoint");

    queryUpdateEmitter.emit(FindAllPhaseTapChangerTablePointQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTablePointProjector.class.getName());
}
