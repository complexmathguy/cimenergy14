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
 * Projector for PhaseTapChangerLinear as outlined for the CQRS pattern. All event handling and
 * query handling related to PhaseTapChangerLinear are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by PhaseTapChangerLinearAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("phaseTapChangerLinear")
@Component("phaseTapChangerLinear-projector")
public class PhaseTapChangerLinearProjector extends PhaseTapChangerLinearEntityProjector {

  // core constructor
  public PhaseTapChangerLinearProjector(
      PhaseTapChangerLinearRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = CreatePhaseTapChangerLinearEvent.class)
  public void handle(CreatePhaseTapChangerLinearEvent event) {
    LOGGER.info("handling CreatePhaseTapChangerLinearEvent - " + event);
    PhaseTapChangerLinear entity = new PhaseTapChangerLinear();
    entity.setPhaseTapChangerLinearId(event.getPhaseTapChangerLinearId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event UpdatePhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = UpdatePhaseTapChangerLinearEvent.class)
  public void handle(UpdatePhaseTapChangerLinearEvent event) {
    LOGGER.info("handling UpdatePhaseTapChangerLinearEvent - " + event);

    PhaseTapChangerLinear entity = new PhaseTapChangerLinear();
    entity.setPhaseTapChangerLinearId(event.getPhaseTapChangerLinearId());
    entity.setStepPhaseShiftIncrement(event.getStepPhaseShiftIncrement());
    entity.setXMax(event.getXMax());
    entity.setXMin(event.getXMin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event DeletePhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = DeletePhaseTapChangerLinearEvent.class)
  public void handle(DeletePhaseTapChangerLinearEvent event) {
    LOGGER.info("handling DeletePhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PhaseTapChangerLinear entity = delete(event.getPhaseTapChangerLinearId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent.class)
  public void handle(AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent event) {
    LOGGER.info("handling AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PhaseTapChangerLinear entity =
        assignStepPhaseShiftIncrement(event.getPhaseTapChangerLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent.class)
  public void handle(UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent event) {
    LOGGER.info(
        "handling UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PhaseTapChangerLinear entity =
        unAssignStepPhaseShiftIncrement(event.getPhaseTapChangerLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event AssignXMaxToPhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = AssignXMaxToPhaseTapChangerLinearEvent.class)
  public void handle(AssignXMaxToPhaseTapChangerLinearEvent event) {
    LOGGER.info("handling AssignXMaxToPhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PhaseTapChangerLinear entity =
        assignXMax(event.getPhaseTapChangerLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event UnAssignXMaxFromPhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = UnAssignXMaxFromPhaseTapChangerLinearEvent.class)
  public void handle(UnAssignXMaxFromPhaseTapChangerLinearEvent event) {
    LOGGER.info("handling UnAssignXMaxFromPhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PhaseTapChangerLinear entity = unAssignXMax(event.getPhaseTapChangerLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event AssignXMinToPhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = AssignXMinToPhaseTapChangerLinearEvent.class)
  public void handle(AssignXMinToPhaseTapChangerLinearEvent event) {
    LOGGER.info("handling AssignXMinToPhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PhaseTapChangerLinear entity =
        assignXMin(event.getPhaseTapChangerLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /*
   * @param	event UnAssignXMinFromPhaseTapChangerLinearEvent
   */
  @EventHandler(payloadType = UnAssignXMinFromPhaseTapChangerLinearEvent.class)
  public void handle(UnAssignXMinFromPhaseTapChangerLinearEvent event) {
    LOGGER.info("handling UnAssignXMinFromPhaseTapChangerLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PhaseTapChangerLinear entity = unAssignXMin(event.getPhaseTapChangerLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPhaseTapChangerLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPhaseTapChangerLinear(entity);
  }

  /**
   * Method to retrieve the PhaseTapChangerLinear via an PhaseTapChangerLinearPrimaryKey.
   *
   * @param id Long
   * @return PhaseTapChangerLinear
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PhaseTapChangerLinear handle(FindPhaseTapChangerLinearQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPhaseTapChangerLinearId());
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerLinears
   *
   * @param query FindAllPhaseTapChangerLinearQuery
   * @return List<PhaseTapChangerLinear>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PhaseTapChangerLinear> handle(FindAllPhaseTapChangerLinearQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPhaseTapChangerLinear, but only if the id matches
   *
   * @param entity PhaseTapChangerLinear
   */
  protected void emitFindPhaseTapChangerLinear(PhaseTapChangerLinear entity) {
    LOGGER.info("handling emitFindPhaseTapChangerLinear");

    queryUpdateEmitter.emit(
        FindPhaseTapChangerLinearQuery.class,
        query ->
            query
                .getFilter()
                .getPhaseTapChangerLinearId()
                .equals(entity.getPhaseTapChangerLinearId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPhaseTapChangerLinear
   *
   * @param entity PhaseTapChangerLinear
   */
  protected void emitFindAllPhaseTapChangerLinear(PhaseTapChangerLinear entity) {
    LOGGER.info("handling emitFindAllPhaseTapChangerLinear");

    queryUpdateEmitter.emit(FindAllPhaseTapChangerLinearQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerLinearProjector.class.getName());
}
