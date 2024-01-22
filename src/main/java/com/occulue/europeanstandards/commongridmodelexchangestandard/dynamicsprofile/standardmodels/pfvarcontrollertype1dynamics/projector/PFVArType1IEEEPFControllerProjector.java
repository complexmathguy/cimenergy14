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
 * Projector for PFVArType1IEEEPFController as outlined for the CQRS pattern. All event handling and
 * query handling related to PFVArType1IEEEPFController are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by PFVArType1IEEEPFControllerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pFVArType1IEEEPFController")
@Component("pFVArType1IEEEPFController-projector")
public class PFVArType1IEEEPFControllerProjector extends PFVArType1IEEEPFControllerEntityProjector {

  // core constructor
  public PFVArType1IEEEPFControllerProjector(
      PFVArType1IEEEPFControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = CreatePFVArType1IEEEPFControllerEvent.class)
  public void handle(CreatePFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling CreatePFVArType1IEEEPFControllerEvent - " + event);
    PFVArType1IEEEPFController entity = new PFVArType1IEEEPFController();
    entity.setPFVArType1IEEEPFControllerId(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UpdatePFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UpdatePFVArType1IEEEPFControllerEvent.class)
  public void handle(UpdatePFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UpdatePFVArType1IEEEPFControllerEvent - " + event);

    PFVArType1IEEEPFController entity = new PFVArType1IEEEPFController();
    entity.setPFVArType1IEEEPFControllerId(event.getPFVArType1IEEEPFControllerId());
    entity.setOvex(event.getOvex());
    entity.setTpfc(event.getTpfc());
    entity.setVitmin(event.getVitmin());
    entity.setVpf(event.getVpf());
    entity.setVpfcbw(event.getVpfcbw());
    entity.setVpfref(event.getVpfref());
    entity.setVvtmax(event.getVvtmax());
    entity.setVvtmin(event.getVvtmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event DeletePFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = DeletePFVArType1IEEEPFControllerEvent.class)
  public void handle(DeletePFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling DeletePFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PFVArType1IEEEPFController entity = delete(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignOvexToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignOvexToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignOvexToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignOvexToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignOvex(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignOvexFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignOvexFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignOvexFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignOvexFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignOvex(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignTpfcToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignTpfcToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignTpfcToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignTpfcToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignTpfc(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignTpfcFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignTpfcFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignTpfcFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignTpfcFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignTpfc(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignVitminToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVitminToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignVitminToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVitminToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignVitmin(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVitminFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVitminFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignVitminFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVitminFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignVitmin(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignVpfToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVpfToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignVpfToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVpfToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignVpf(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVpfFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVpfFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignVpfFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVpfFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignVpf(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignVpfcbwToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVpfcbwToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignVpfcbwToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVpfcbwToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignVpfcbw(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignVpfcbw(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignVpfrefToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVpfrefToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignVpfrefToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVpfrefToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignVpfref(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignVpfref(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignVvtmaxToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVvtmaxToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignVvtmaxToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVvtmaxToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignVvtmax(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignVvtmax(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event AssignVvtminToPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVvtminToPFVArType1IEEEPFControllerEvent.class)
  public void handle(AssignVvtminToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVvtminToPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType1IEEEPFController entity =
        assignVvtmin(event.getPFVArType1IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVvtminFromPFVArType1IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVvtminFromPFVArType1IEEEPFControllerEvent.class)
  public void handle(UnAssignVvtminFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVvtminFromPFVArType1IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType1IEEEPFController entity = unAssignVvtmin(event.getPFVArType1IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType1IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType1IEEEPFController(entity);
  }

  /**
   * Method to retrieve the PFVArType1IEEEPFController via an PFVArType1IEEEPFControllerPrimaryKey.
   *
   * @param id Long
   * @return PFVArType1IEEEPFController
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PFVArType1IEEEPFController handle(FindPFVArType1IEEEPFControllerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPFVArType1IEEEPFControllerId());
  }

  /**
   * Method to retrieve a collection of all PFVArType1IEEEPFControllers
   *
   * @param query FindAllPFVArType1IEEEPFControllerQuery
   * @return List<PFVArType1IEEEPFController>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PFVArType1IEEEPFController> handle(FindAllPFVArType1IEEEPFControllerQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPFVArType1IEEEPFController, but only if the id matches
   *
   * @param entity PFVArType1IEEEPFController
   */
  protected void emitFindPFVArType1IEEEPFController(PFVArType1IEEEPFController entity) {
    LOGGER.info("handling emitFindPFVArType1IEEEPFController");

    queryUpdateEmitter.emit(
        FindPFVArType1IEEEPFControllerQuery.class,
        query ->
            query
                .getFilter()
                .getPFVArType1IEEEPFControllerId()
                .equals(entity.getPFVArType1IEEEPFControllerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPFVArType1IEEEPFController
   *
   * @param entity PFVArType1IEEEPFController
   */
  protected void emitFindAllPFVArType1IEEEPFController(PFVArType1IEEEPFController entity) {
    LOGGER.info("handling emitFindAllPFVArType1IEEEPFController");

    queryUpdateEmitter.emit(FindAllPFVArType1IEEEPFControllerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEPFControllerProjector.class.getName());
}
