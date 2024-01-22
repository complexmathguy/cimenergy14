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
 * Projector for Control as outlined for the CQRS pattern. All event handling and query handling
 * related to Control are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ControlAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("control")
@Component("control-projector")
public class ControlProjector extends ControlEntityProjector {

  // core constructor
  public ControlProjector(ControlRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateControlEvent
   */
  @EventHandler(payloadType = CreateControlEvent.class)
  public void handle(CreateControlEvent event) {
    LOGGER.info("handling CreateControlEvent - " + event);
    Control entity = new Control();
    entity.setControlId(event.getControlId());
    entity.setUnitMultiplier(event.getUnitMultiplier());
    entity.setUnitSymbol(event.getUnitSymbol());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event UpdateControlEvent
   */
  @EventHandler(payloadType = UpdateControlEvent.class)
  public void handle(UpdateControlEvent event) {
    LOGGER.info("handling UpdateControlEvent - " + event);

    Control entity = new Control();
    entity.setControlId(event.getControlId());
    entity.setControlType(event.getControlType());
    entity.setOperationInProgress(event.getOperationInProgress());
    entity.setTimeStamp(event.getTimeStamp());
    entity.setUnitMultiplier(event.getUnitMultiplier());
    entity.setUnitSymbol(event.getUnitSymbol());
    entity.setControls(event.getControls());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event DeleteControlEvent
   */
  @EventHandler(payloadType = DeleteControlEvent.class)
  public void handle(DeleteControlEvent event) {
    LOGGER.info("handling DeleteControlEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Control entity = delete(event.getControlId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event AssignControlTypeToControlEvent
   */
  @EventHandler(payloadType = AssignControlTypeToControlEvent.class)
  public void handle(AssignControlTypeToControlEvent event) {
    LOGGER.info("handling AssignControlTypeToControlEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Control entity = assignControlType(event.getControlId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event UnAssignControlTypeFromControlEvent
   */
  @EventHandler(payloadType = UnAssignControlTypeFromControlEvent.class)
  public void handle(UnAssignControlTypeFromControlEvent event) {
    LOGGER.info("handling UnAssignControlTypeFromControlEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Control entity = unAssignControlType(event.getControlId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event AssignOperationInProgressToControlEvent
   */
  @EventHandler(payloadType = AssignOperationInProgressToControlEvent.class)
  public void handle(AssignOperationInProgressToControlEvent event) {
    LOGGER.info("handling AssignOperationInProgressToControlEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Control entity = assignOperationInProgress(event.getControlId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event UnAssignOperationInProgressFromControlEvent
   */
  @EventHandler(payloadType = UnAssignOperationInProgressFromControlEvent.class)
  public void handle(UnAssignOperationInProgressFromControlEvent event) {
    LOGGER.info("handling UnAssignOperationInProgressFromControlEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Control entity = unAssignOperationInProgress(event.getControlId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event AssignTimeStampToControlEvent
   */
  @EventHandler(payloadType = AssignTimeStampToControlEvent.class)
  public void handle(AssignTimeStampToControlEvent event) {
    LOGGER.info("handling AssignTimeStampToControlEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Control entity = assignTimeStamp(event.getControlId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event UnAssignTimeStampFromControlEvent
   */
  @EventHandler(payloadType = UnAssignTimeStampFromControlEvent.class)
  public void handle(UnAssignTimeStampFromControlEvent event) {
    LOGGER.info("handling UnAssignTimeStampFromControlEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Control entity = unAssignTimeStamp(event.getControlId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event AssignControlsToControlEvent
   */
  @EventHandler(payloadType = AssignControlsToControlEvent.class)
  public void handle(AssignControlsToControlEvent event) {
    LOGGER.info("handling AssignControlsToControlEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    Control entity = addToControls(event.getControlId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /*
   * @param	event RemoveControlsFromControlEvent
   */
  @EventHandler(payloadType = RemoveControlsFromControlEvent.class)
  public void handle(RemoveControlsFromControlEvent event) {
    LOGGER.info("handling RemoveControlsFromControlEvent - " + event);

    Control entity = removeFromControls(event.getControlId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindControl(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllControl(entity);
  }

  /**
   * Method to retrieve the Control via an ControlPrimaryKey.
   *
   * @param id Long
   * @return Control
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Control handle(FindControlQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getControlId());
  }

  /**
   * Method to retrieve a collection of all Controls
   *
   * @param query FindAllControlQuery
   * @return List<Control>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Control> handle(FindAllControlQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindControl, but only if the id matches
   *
   * @param entity Control
   */
  protected void emitFindControl(Control entity) {
    LOGGER.info("handling emitFindControl");

    queryUpdateEmitter.emit(
        FindControlQuery.class,
        query -> query.getFilter().getControlId().equals(entity.getControlId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllControl
   *
   * @param entity Control
   */
  protected void emitFindAllControl(Control entity) {
    LOGGER.info("handling emitFindAllControl");

    queryUpdateEmitter.emit(FindAllControlQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ControlProjector.class.getName());
}
