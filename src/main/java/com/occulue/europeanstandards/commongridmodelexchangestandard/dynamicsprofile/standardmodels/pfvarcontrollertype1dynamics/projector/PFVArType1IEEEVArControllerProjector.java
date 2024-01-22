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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArType1IEEEVArController as outlined for the CQRS pattern. All event handling
 * and query handling related to PFVArType1IEEEVArController are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by PFVArType1IEEEVArControllerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pFVArType1IEEEVArController")
@Component("pFVArType1IEEEVArController-projector")
public class PFVArType1IEEEVArControllerProjector
    extends PFVArType1IEEEVArControllerEntityProjector {

  // core constructor
  public PFVArType1IEEEVArControllerProjector(
      PFVArType1IEEEVArControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = CreatePFVArType1IEEEVArControllerEvent.class)
  public void handle(CreatePFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling CreatePFVArType1IEEEVArControllerEvent - " + event);
    PFVArType1IEEEVArController entity = new PFVArType1IEEEVArController();
    entity.setPFVArType1IEEEVArControllerId(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UpdatePFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UpdatePFVArType1IEEEVArControllerEvent.class)
  public void handle(UpdatePFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UpdatePFVArType1IEEEVArControllerEvent - " + event);

    PFVArType1IEEEVArController entity = new PFVArType1IEEEVArController();
    entity.setPFVArType1IEEEVArControllerId(event.getPFVArType1IEEEVArControllerId());
    entity.setTvarc(event.getTvarc());
    entity.setVvar(event.getVvar());
    entity.setVvarcbw(event.getVvarcbw());
    entity.setVvarref(event.getVvarref());
    entity.setVvtmax(event.getVvtmax());
    entity.setVvtmin(event.getVvtmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event DeletePFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = DeletePFVArType1IEEEVArControllerEvent.class)
  public void handle(DeletePFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling DeletePFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PFVArType1IEEEVArController entity = delete(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event AssignTvarcToPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignTvarcToPFVArType1IEEEVArControllerEvent.class)
  public void handle(AssignTvarcToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignTvarcToPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEVArController entity =
        assignTvarc(event.getPFVArType1IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignTvarcFromPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignTvarcFromPFVArType1IEEEVArControllerEvent.class)
  public void handle(UnAssignTvarcFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignTvarcFromPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEVArController entity = unAssignTvarc(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event AssignVvarToPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVvarToPFVArType1IEEEVArControllerEvent.class)
  public void handle(AssignVvarToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVvarToPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEVArController entity =
        assignVvar(event.getPFVArType1IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVvarFromPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvarFromPFVArType1IEEEVArControllerEvent.class)
  public void handle(UnAssignVvarFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVvarFromPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEVArController entity = unAssignVvar(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event AssignVvarcbwToPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVvarcbwToPFVArType1IEEEVArControllerEvent.class)
  public void handle(AssignVvarcbwToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVvarcbwToPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEVArController entity =
        assignVvarcbw(event.getPFVArType1IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent.class)
  public void handle(UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEVArController entity = unAssignVvarcbw(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event AssignVvarrefToPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVvarrefToPFVArType1IEEEVArControllerEvent.class)
  public void handle(AssignVvarrefToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVvarrefToPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEVArController entity =
        assignVvarref(event.getPFVArType1IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent.class)
  public void handle(UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEVArController entity = unAssignVvarref(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event AssignVvtmaxToPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVvtmaxToPFVArType1IEEEVArControllerEvent.class)
  public void handle(AssignVvtmaxToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVvtmaxToPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEVArController entity =
        assignVvtmax(event.getPFVArType1IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent.class)
  public void handle(UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEVArController entity = unAssignVvtmax(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event AssignVvtminToPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVvtminToPFVArType1IEEEVArControllerEvent.class)
  public void handle(AssignVvtminToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVvtminToPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEVArController entity =
        assignVvtmin(event.getPFVArType1IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVvtminFromPFVArType1IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvtminFromPFVArType1IEEEVArControllerEvent.class)
  public void handle(UnAssignVvtminFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVvtminFromPFVArType1IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEVArController entity = unAssignVvtmin(event.getPFVArType1IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEVArController(entity);
  }

  /**
   * Method to retrieve the PFVArType1IEEEVArController via an
   * PFVArType1IEEEVArControllerPrimaryKey.
   *
   * @param id Long
   * @return PFVArType1IEEEVArController
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PFVArType1IEEEVArController handle(FindPFVArType1IEEEVArControllerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPFVArType1IEEEVArControllerId());
  }

  /**
   * Method to retrieve a collection of all PFVArType1IEEEVArControllers
   *
   * @param query FindAllPFVArType1IEEEVArControllerQuery
   * @return List<PFVArType1IEEEVArController>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PFVArType1IEEEVArController> handle(FindAllPFVArType1IEEEVArControllerQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPFVArType1IEEEVArController, but only if the id
   * matches
   *
   * @param entity PFVArType1IEEEVArController
   */
  protected void emitFindPFVArType1IEEEVArController(PFVArType1IEEEVArController entity) {
    LOGGER.info("handling emitFindPFVArType1IEEEVArController");

    queryUpdateEmitter.emit(
        FindPFVArType1IEEEVArControllerQuery.class,
        query ->
            query
                .getFilter()
                .getPFVArType1IEEEVArControllerId()
                .equals(entity.getPFVArType1IEEEVArControllerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPFVArType1IEEEVArController
   *
   * @param entity PFVArType1IEEEVArController
   */
  protected void emitFindAllPFVArType1IEEEVArController(PFVArType1IEEEVArController entity) {
    LOGGER.info("handling emitFindAllPFVArType1IEEEVArController");

    queryUpdateEmitter.emit(FindAllPFVArType1IEEEVArControllerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEVArControllerProjector.class.getName());
}
