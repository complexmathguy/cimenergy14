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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for TurbLCFB1 as outlined for the CQRS pattern. All event handling and query handling
 * related to TurbLCFB1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by TurbLCFB1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("turbLCFB1")
@Component("turbLCFB1-projector")
public class TurbLCFB1Projector extends TurbLCFB1EntityProjector {

  // core constructor
  public TurbLCFB1Projector(TurbLCFB1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTurbLCFB1Event
   */
  @EventHandler(payloadType = CreateTurbLCFB1Event.class)
  public void handle(CreateTurbLCFB1Event event) {
    LOGGER.info("handling CreateTurbLCFB1Event - " + event);
    TurbLCFB1 entity = new TurbLCFB1();
    entity.setTurbLCFB1Id(event.getTurbLCFB1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UpdateTurbLCFB1Event
   */
  @EventHandler(payloadType = UpdateTurbLCFB1Event.class)
  public void handle(UpdateTurbLCFB1Event event) {
    LOGGER.info("handling UpdateTurbLCFB1Event - " + event);

    TurbLCFB1 entity = new TurbLCFB1();
    entity.setTurbLCFB1Id(event.getTurbLCFB1Id());
    entity.setDb(event.getDb());
    entity.setEmax(event.getEmax());
    entity.setFb(event.getFb());
    entity.setFbf(event.getFbf());
    entity.setIrmax(event.getIrmax());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMwbase(event.getMwbase());
    entity.setPbf(event.getPbf());
    entity.setPmwset(event.getPmwset());
    entity.setSpeedReferenceGovernor(event.getSpeedReferenceGovernor());
    entity.setTpelec(event.getTpelec());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event DeleteTurbLCFB1Event
   */
  @EventHandler(payloadType = DeleteTurbLCFB1Event.class)
  public void handle(DeleteTurbLCFB1Event event) {
    LOGGER.info("handling DeleteTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TurbLCFB1 entity = delete(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignDbToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignDbToTurbLCFB1Event.class)
  public void handle(AssignDbToTurbLCFB1Event event) {
    LOGGER.info("handling AssignDbToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignDb(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignDbFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignDbFromTurbLCFB1Event.class)
  public void handle(UnAssignDbFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignDbFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignDb(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignEmaxToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignEmaxToTurbLCFB1Event.class)
  public void handle(AssignEmaxToTurbLCFB1Event event) {
    LOGGER.info("handling AssignEmaxToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignEmax(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignEmaxFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignEmaxFromTurbLCFB1Event.class)
  public void handle(UnAssignEmaxFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignEmaxFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignEmax(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignFbToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignFbToTurbLCFB1Event.class)
  public void handle(AssignFbToTurbLCFB1Event event) {
    LOGGER.info("handling AssignFbToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignFb(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignFbFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignFbFromTurbLCFB1Event.class)
  public void handle(UnAssignFbFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignFbFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignFb(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignFbfToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignFbfToTurbLCFB1Event.class)
  public void handle(AssignFbfToTurbLCFB1Event event) {
    LOGGER.info("handling AssignFbfToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignFbf(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignFbfFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignFbfFromTurbLCFB1Event.class)
  public void handle(UnAssignFbfFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignFbfFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignFbf(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignIrmaxToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignIrmaxToTurbLCFB1Event.class)
  public void handle(AssignIrmaxToTurbLCFB1Event event) {
    LOGGER.info("handling AssignIrmaxToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignIrmax(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignIrmaxFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignIrmaxFromTurbLCFB1Event.class)
  public void handle(UnAssignIrmaxFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignIrmaxFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignIrmax(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignKiToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignKiToTurbLCFB1Event.class)
  public void handle(AssignKiToTurbLCFB1Event event) {
    LOGGER.info("handling AssignKiToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignKi(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignKiFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignKiFromTurbLCFB1Event.class)
  public void handle(UnAssignKiFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignKiFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignKi(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignKpToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignKpToTurbLCFB1Event.class)
  public void handle(AssignKpToTurbLCFB1Event event) {
    LOGGER.info("handling AssignKpToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignKp(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignKpFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignKpFromTurbLCFB1Event.class)
  public void handle(UnAssignKpFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignKpFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignKp(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignMwbaseToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignMwbaseToTurbLCFB1Event.class)
  public void handle(AssignMwbaseToTurbLCFB1Event event) {
    LOGGER.info("handling AssignMwbaseToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignMwbase(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromTurbLCFB1Event.class)
  public void handle(UnAssignMwbaseFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignMwbaseFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignMwbase(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignPbfToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignPbfToTurbLCFB1Event.class)
  public void handle(AssignPbfToTurbLCFB1Event event) {
    LOGGER.info("handling AssignPbfToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignPbf(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignPbfFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignPbfFromTurbLCFB1Event.class)
  public void handle(UnAssignPbfFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignPbfFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignPbf(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignPmwsetToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignPmwsetToTurbLCFB1Event.class)
  public void handle(AssignPmwsetToTurbLCFB1Event event) {
    LOGGER.info("handling AssignPmwsetToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignPmwset(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignPmwsetFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignPmwsetFromTurbLCFB1Event.class)
  public void handle(UnAssignPmwsetFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignPmwsetFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignPmwset(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignSpeedReferenceGovernorToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignSpeedReferenceGovernorToTurbLCFB1Event.class)
  public void handle(AssignSpeedReferenceGovernorToTurbLCFB1Event event) {
    LOGGER.info("handling AssignSpeedReferenceGovernorToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignSpeedReferenceGovernor(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignSpeedReferenceGovernorFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignSpeedReferenceGovernorFromTurbLCFB1Event.class)
  public void handle(UnAssignSpeedReferenceGovernorFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignSpeedReferenceGovernorFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignSpeedReferenceGovernor(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event AssignTpelecToTurbLCFB1Event
   */
  @EventHandler(payloadType = AssignTpelecToTurbLCFB1Event.class)
  public void handle(AssignTpelecToTurbLCFB1Event event) {
    LOGGER.info("handling AssignTpelecToTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbLCFB1 entity = assignTpelec(event.getTurbLCFB1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /*
   * @param	event UnAssignTpelecFromTurbLCFB1Event
   */
  @EventHandler(payloadType = UnAssignTpelecFromTurbLCFB1Event.class)
  public void handle(UnAssignTpelecFromTurbLCFB1Event event) {
    LOGGER.info("handling UnAssignTpelecFromTurbLCFB1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbLCFB1 entity = unAssignTpelec(event.getTurbLCFB1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbLCFB1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbLCFB1(entity);
  }

  /**
   * Method to retrieve the TurbLCFB1 via an TurbLCFB1PrimaryKey.
   *
   * @param id Long
   * @return TurbLCFB1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TurbLCFB1 handle(FindTurbLCFB1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTurbLCFB1Id());
  }

  /**
   * Method to retrieve a collection of all TurbLCFB1s
   *
   * @param query FindAllTurbLCFB1Query
   * @return List<TurbLCFB1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TurbLCFB1> handle(FindAllTurbLCFB1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTurbLCFB1, but only if the id matches
   *
   * @param entity TurbLCFB1
   */
  protected void emitFindTurbLCFB1(TurbLCFB1 entity) {
    LOGGER.info("handling emitFindTurbLCFB1");

    queryUpdateEmitter.emit(
        FindTurbLCFB1Query.class,
        query -> query.getFilter().getTurbLCFB1Id().equals(entity.getTurbLCFB1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTurbLCFB1
   *
   * @param entity TurbLCFB1
   */
  protected void emitFindAllTurbLCFB1(TurbLCFB1 entity) {
    LOGGER.info("handling emitFindAllTurbLCFB1");

    queryUpdateEmitter.emit(FindAllTurbLCFB1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(TurbLCFB1Projector.class.getName());
}
