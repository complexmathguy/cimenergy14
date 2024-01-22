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
 * Projector for PFVArType2IEEEVArController as outlined for the CQRS pattern. All event handling
 * and query handling related to PFVArType2IEEEVArController are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by PFVArType2IEEEVArControllerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pFVArType2IEEEVArController")
@Component("pFVArType2IEEEVArController-projector")
public class PFVArType2IEEEVArControllerProjector
    extends PFVArType2IEEEVArControllerEntityProjector {

  // core constructor
  public PFVArType2IEEEVArControllerProjector(
      PFVArType2IEEEVArControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = CreatePFVArType2IEEEVArControllerEvent.class)
  public void handle(CreatePFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling CreatePFVArType2IEEEVArControllerEvent - " + event);
    PFVArType2IEEEVArController entity = new PFVArType2IEEEVArController();
    entity.setPFVArType2IEEEVArControllerId(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UpdatePFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UpdatePFVArType2IEEEVArControllerEvent.class)
  public void handle(UpdatePFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UpdatePFVArType2IEEEVArControllerEvent - " + event);

    PFVArType2IEEEVArController entity = new PFVArType2IEEEVArController();
    entity.setPFVArType2IEEEVArControllerId(event.getPFVArType2IEEEVArControllerId());
    entity.setExlon(event.getExlon());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setQref(event.getQref());
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
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event DeletePFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = DeletePFVArType2IEEEVArControllerEvent.class)
  public void handle(DeletePFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling DeletePFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PFVArType2IEEEVArController entity = delete(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignExlonToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignExlonToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignExlonToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignExlonToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignExlon(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignExlonFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignExlonFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignExlonFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignExlonFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignExlon(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignKiToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignKiToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignKiToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignKiToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignKi(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignKiFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignKiFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignKiFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignKiFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignKi(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignKpToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignKpToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignKpToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignKpToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignKp(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignKpFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignKpFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignKpFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignKpFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignKp(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignQrefToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignQrefToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignQrefToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignQrefToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignQref(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignQrefFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignQrefFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignQrefFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignQrefFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignQref(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignVclmtToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVclmtToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignVclmtToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVclmtToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignVclmt(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVclmtFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVclmtFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignVclmtFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVclmtFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignVclmt(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignVrefToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVrefToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignVrefToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVrefToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignVref(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVrefFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVrefFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignVrefFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVrefFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignVref(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event AssignVsToPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = AssignVsToPFVArType2IEEEVArControllerEvent.class)
  public void handle(AssignVsToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling AssignVsToPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2IEEEVArController entity =
        assignVs(event.getPFVArType2IEEEVArControllerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /*
   * @param	event UnAssignVsFromPFVArType2IEEEVArControllerEvent
   */
  @EventHandler(payloadType = UnAssignVsFromPFVArType2IEEEVArControllerEvent.class)
  public void handle(UnAssignVsFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("handling UnAssignVsFromPFVArType2IEEEVArControllerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2IEEEVArController entity = unAssignVs(event.getPFVArType2IEEEVArControllerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2IEEEVArController(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2IEEEVArController(entity);
  }

  /**
   * Method to retrieve the PFVArType2IEEEVArController via an
   * PFVArType2IEEEVArControllerPrimaryKey.
   *
   * @param id Long
   * @return PFVArType2IEEEVArController
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PFVArType2IEEEVArController handle(FindPFVArType2IEEEVArControllerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPFVArType2IEEEVArControllerId());
  }

  /**
   * Method to retrieve a collection of all PFVArType2IEEEVArControllers
   *
   * @param query FindAllPFVArType2IEEEVArControllerQuery
   * @return List<PFVArType2IEEEVArController>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PFVArType2IEEEVArController> handle(FindAllPFVArType2IEEEVArControllerQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPFVArType2IEEEVArController, but only if the id
   * matches
   *
   * @param entity PFVArType2IEEEVArController
   */
  protected void emitFindPFVArType2IEEEVArController(PFVArType2IEEEVArController entity) {
    LOGGER.info("handling emitFindPFVArType2IEEEVArController");

    queryUpdateEmitter.emit(
        FindPFVArType2IEEEVArControllerQuery.class,
        query ->
            query
                .getFilter()
                .getPFVArType2IEEEVArControllerId()
                .equals(entity.getPFVArType2IEEEVArControllerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPFVArType2IEEEVArController
   *
   * @param entity PFVArType2IEEEVArController
   */
  protected void emitFindAllPFVArType2IEEEVArController(PFVArType2IEEEVArController entity) {
    LOGGER.info("handling emitFindAllPFVArType2IEEEVArController");

    queryUpdateEmitter.emit(FindAllPFVArType2IEEEVArControllerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEVArControllerProjector.class.getName());
}
