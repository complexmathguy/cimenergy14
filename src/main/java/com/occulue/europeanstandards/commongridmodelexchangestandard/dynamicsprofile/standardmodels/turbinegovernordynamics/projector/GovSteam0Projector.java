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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovSteam0 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteam0 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteam0Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteam0")
@Component("govSteam0-projector")
public class GovSteam0Projector extends GovSteam0EntityProjector {

  // core constructor
  public GovSteam0Projector(GovSteam0Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteam0Event
   */
  @EventHandler(payloadType = CreateGovSteam0Event.class)
  public void handle(CreateGovSteam0Event event) {
    LOGGER.info("handling CreateGovSteam0Event - " + event);
    GovSteam0 entity = new GovSteam0();
    entity.setGovSteam0Id(event.getGovSteam0Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UpdateGovSteam0Event
   */
  @EventHandler(payloadType = UpdateGovSteam0Event.class)
  public void handle(UpdateGovSteam0Event event) {
    LOGGER.info("handling UpdateGovSteam0Event - " + event);

    GovSteam0 entity = new GovSteam0();
    entity.setGovSteam0Id(event.getGovSteam0Id());
    entity.setDt(event.getDt());
    entity.setMwbase(event.getMwbase());
    entity.setR(event.getR());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event DeleteGovSteam0Event
   */
  @EventHandler(payloadType = DeleteGovSteam0Event.class)
  public void handle(DeleteGovSteam0Event event) {
    LOGGER.info("handling DeleteGovSteam0Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteam0 entity = delete(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignDtToGovSteam0Event
   */
  @EventHandler(payloadType = AssignDtToGovSteam0Event.class)
  public void handle(AssignDtToGovSteam0Event event) {
    LOGGER.info("handling AssignDtToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignDt(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignDtFromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignDtFromGovSteam0Event.class)
  public void handle(UnAssignDtFromGovSteam0Event event) {
    LOGGER.info("handling UnAssignDtFromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignDt(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteam0Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteam0Event.class)
  public void handle(AssignMwbaseToGovSteam0Event event) {
    LOGGER.info("handling AssignMwbaseToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignMwbase(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteam0Event.class)
  public void handle(UnAssignMwbaseFromGovSteam0Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignMwbase(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignRToGovSteam0Event
   */
  @EventHandler(payloadType = AssignRToGovSteam0Event.class)
  public void handle(AssignRToGovSteam0Event event) {
    LOGGER.info("handling AssignRToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignR(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignRFromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignRFromGovSteam0Event.class)
  public void handle(UnAssignRFromGovSteam0Event event) {
    LOGGER.info("handling UnAssignRFromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignR(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignT1ToGovSteam0Event
   */
  @EventHandler(payloadType = AssignT1ToGovSteam0Event.class)
  public void handle(AssignT1ToGovSteam0Event event) {
    LOGGER.info("handling AssignT1ToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignT1(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteam0Event.class)
  public void handle(UnAssignT1FromGovSteam0Event event) {
    LOGGER.info("handling UnAssignT1FromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignT1(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignT2ToGovSteam0Event
   */
  @EventHandler(payloadType = AssignT2ToGovSteam0Event.class)
  public void handle(AssignT2ToGovSteam0Event event) {
    LOGGER.info("handling AssignT2ToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignT2(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignT2FromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovSteam0Event.class)
  public void handle(UnAssignT2FromGovSteam0Event event) {
    LOGGER.info("handling UnAssignT2FromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignT2(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignT3ToGovSteam0Event
   */
  @EventHandler(payloadType = AssignT3ToGovSteam0Event.class)
  public void handle(AssignT3ToGovSteam0Event event) {
    LOGGER.info("handling AssignT3ToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignT3(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignT3FromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovSteam0Event.class)
  public void handle(UnAssignT3FromGovSteam0Event event) {
    LOGGER.info("handling UnAssignT3FromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignT3(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignVmaxToGovSteam0Event
   */
  @EventHandler(payloadType = AssignVmaxToGovSteam0Event.class)
  public void handle(AssignVmaxToGovSteam0Event event) {
    LOGGER.info("handling AssignVmaxToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignVmax(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignVmaxFromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignVmaxFromGovSteam0Event.class)
  public void handle(UnAssignVmaxFromGovSteam0Event event) {
    LOGGER.info("handling UnAssignVmaxFromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignVmax(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event AssignVminToGovSteam0Event
   */
  @EventHandler(payloadType = AssignVminToGovSteam0Event.class)
  public void handle(AssignVminToGovSteam0Event event) {
    LOGGER.info("handling AssignVminToGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam0 entity = assignVmin(event.getGovSteam0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /*
   * @param	event UnAssignVminFromGovSteam0Event
   */
  @EventHandler(payloadType = UnAssignVminFromGovSteam0Event.class)
  public void handle(UnAssignVminFromGovSteam0Event event) {
    LOGGER.info("handling UnAssignVminFromGovSteam0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam0 entity = unAssignVmin(event.getGovSteam0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam0(entity);
  }

  /**
   * Method to retrieve the GovSteam0 via an GovSteam0PrimaryKey.
   *
   * @param id Long
   * @return GovSteam0
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteam0 handle(FindGovSteam0Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteam0Id());
  }

  /**
   * Method to retrieve a collection of all GovSteam0s
   *
   * @param query FindAllGovSteam0Query
   * @return List<GovSteam0>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteam0> handle(FindAllGovSteam0Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteam0, but only if the id matches
   *
   * @param entity GovSteam0
   */
  protected void emitFindGovSteam0(GovSteam0 entity) {
    LOGGER.info("handling emitFindGovSteam0");

    queryUpdateEmitter.emit(
        FindGovSteam0Query.class,
        query -> query.getFilter().getGovSteam0Id().equals(entity.getGovSteam0Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteam0
   *
   * @param entity GovSteam0
   */
  protected void emitFindAllGovSteam0(GovSteam0 entity) {
    LOGGER.info("handling emitFindAllGovSteam0");

    queryUpdateEmitter.emit(FindAllGovSteam0Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteam0Projector.class.getName());
}
