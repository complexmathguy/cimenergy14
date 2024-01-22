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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArType2IEEEPFController as outlined for the CQRS pattern. All event handling and
 * query handling related to PFVArType2IEEEPFController are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by PFVArType2IEEEPFControllerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pFVArType2IEEEPFController")
@Component("pFVArType2IEEEPFController-projector")
public class PFVArType2IEEEPFControllerProjector extends PFVArType2IEEEPFControllerEntityProjector {

  // core constructor
  public PFVArType2IEEEPFControllerProjector(
      PFVArType2IEEEPFControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = CreatePFVArType2IEEEPFControllerEvent.class)
  public void handle(CreatePFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling CreatePFVArType2IEEEPFControllerEvent - " + event);
    PFVArType2IEEEPFController entity = new PFVArType2IEEEPFController();
    entity.setPFVArType2IEEEPFControllerId(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UpdatePFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UpdatePFVArType2IEEEPFControllerEvent.class)
  public void handle(UpdatePFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UpdatePFVArType2IEEEPFControllerEvent - " + event);

    PFVArType2IEEEPFController entity = new PFVArType2IEEEPFController();
    entity.setPFVArType2IEEEPFControllerId(event.getPFVArType2IEEEPFControllerId());
    entity.setExlon(event.getExlon());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setPfref(event.getPfref());
    entity.setVclmt(event.getVclmt());
    entity.setVref(event.getVref());
    entity.setVs(event.getVs());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event DeletePFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = DeletePFVArType2IEEEPFControllerEvent.class)
  public void handle(DeletePFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling DeletePFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PFVArType2IEEEPFController entity = delete(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignExlonToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignExlonToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignExlonToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignExlonToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignExlon(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignExlonFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignExlonFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignExlonFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignExlonFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignExlon(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignKiToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignKiToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignKiToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignKiToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignKi(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignKiFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignKiFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignKiFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignKiFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignKi(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignKpToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignKpToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignKpToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignKpToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignKp(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignKpFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignKpFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignKpFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignKpFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignKp(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignPfrefToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignPfrefToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignPfrefToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignPfrefToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignPfref(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignPfrefFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignPfrefFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignPfrefFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignPfrefFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignPfref(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignVclmtToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVclmtToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignVclmtToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVclmtToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignVclmt(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVclmtFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVclmtFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignVclmtFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVclmtFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignVclmt(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignVrefToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVrefToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignVrefToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVrefToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignVref(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVrefFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVrefFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignVrefFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVrefFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignVref(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event AssignVsToPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = AssignVsToPFVArType2IEEEPFControllerEvent.class)
  public void handle(AssignVsToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling AssignVsToPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEPFController entity =
        assignVs(event.getPFVArType2IEEEPFControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /*
   * @param	event UnAssignVsFromPFVArType2IEEEPFControllerEvent
   */
  @EventHandler(payloadType = UnAssignVsFromPFVArType2IEEEPFControllerEvent.class)
  public void handle(UnAssignVsFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("handling UnAssignVsFromPFVArType2IEEEPFControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEPFController entity = unAssignVs(event.getPFVArType2IEEEPFControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEPFController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEPFController(entity);
  }

  /**
   * Method to retrieve the PFVArType2IEEEPFController via an PFVArType2IEEEPFControllerPrimaryKey.
   *
   * @param id Long
   * @return PFVArType2IEEEPFController
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PFVArType2IEEEPFController handle(FindPFVArType2IEEEPFControllerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPFVArType2IEEEPFControllerId());
  }

  /**
   * Method to retrieve a collection of all PFVArType2IEEEPFControllers
   *
   * @param query FindAllPFVArType2IEEEPFControllerQuery
   * @return List<PFVArType2IEEEPFController>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PFVArType2IEEEPFController> handle(FindAllPFVArType2IEEEPFControllerQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPFVArType2IEEEPFController, but only if the id matches
   *
   * @param entity PFVArType2IEEEPFController
   */
  protected void emitFindPFVArType2IEEEPFController(PFVArType2IEEEPFController entity) {
    LOGGER.info("handling emitFindPFVArType2IEEEPFController");

    queryUpdateEmitter.emit(
        FindPFVArType2IEEEPFControllerQuery.class,
        query ->
            query
                .getFilter()
                .getPFVArType2IEEEPFControllerId()
                .equals(entity.getPFVArType2IEEEPFControllerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPFVArType2IEEEPFController
   *
   * @param entity PFVArType2IEEEPFController
   */
  protected void emitFindAllPFVArType2IEEEPFController(PFVArType2IEEEPFController entity) {
    LOGGER.info("handling emitFindAllPFVArType2IEEEPFController");

    queryUpdateEmitter.emit(FindAllPFVArType2IEEEPFControllerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEPFControllerProjector.class.getName());
}
