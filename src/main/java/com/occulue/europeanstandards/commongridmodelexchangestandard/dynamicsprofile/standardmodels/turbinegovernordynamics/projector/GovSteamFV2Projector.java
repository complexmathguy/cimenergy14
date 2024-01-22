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
 * Projector for GovSteamFV2 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteamFV2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteamFV2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamFV2")
@Component("govSteamFV2-projector")
public class GovSteamFV2Projector extends GovSteamFV2EntityProjector {

  // core constructor
  public GovSteamFV2Projector(
      GovSteamFV2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamFV2Event
   */
  @EventHandler(payloadType = CreateGovSteamFV2Event.class)
  public void handle(CreateGovSteamFV2Event event) {
    LOGGER.info("handling CreateGovSteamFV2Event - " + event);
    GovSteamFV2 entity = new GovSteamFV2();
    entity.setGovSteamFV2Id(event.getGovSteamFV2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UpdateGovSteamFV2Event
   */
  @EventHandler(payloadType = UpdateGovSteamFV2Event.class)
  public void handle(UpdateGovSteamFV2Event event) {
    LOGGER.info("handling UpdateGovSteamFV2Event - " + event);

    GovSteamFV2 entity = new GovSteamFV2();
    entity.setGovSteamFV2Id(event.getGovSteamFV2Id());
    entity.setDt(event.getDt());
    entity.setK(event.getK());
    entity.setMwbase(event.getMwbase());
    entity.setR(event.getR());
    entity.setT1(event.getT1());
    entity.setT3(event.getT3());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTi(event.getTi());
    entity.setTt(event.getTt());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event DeleteGovSteamFV2Event
   */
  @EventHandler(payloadType = DeleteGovSteamFV2Event.class)
  public void handle(DeleteGovSteamFV2Event event) {
    LOGGER.info("handling DeleteGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamFV2 entity = delete(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignDtToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignDtToGovSteamFV2Event.class)
  public void handle(AssignDtToGovSteamFV2Event event) {
    LOGGER.info("handling AssignDtToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignDt(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignDtFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignDtFromGovSteamFV2Event.class)
  public void handle(UnAssignDtFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignDtFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignDt(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignKToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignKToGovSteamFV2Event.class)
  public void handle(AssignKToGovSteamFV2Event event) {
    LOGGER.info("handling AssignKToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignK(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignKFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignKFromGovSteamFV2Event.class)
  public void handle(UnAssignKFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignKFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignK(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteamFV2Event.class)
  public void handle(AssignMwbaseToGovSteamFV2Event event) {
    LOGGER.info("handling AssignMwbaseToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignMwbase(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteamFV2Event.class)
  public void handle(UnAssignMwbaseFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignMwbase(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignRToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignRToGovSteamFV2Event.class)
  public void handle(AssignRToGovSteamFV2Event event) {
    LOGGER.info("handling AssignRToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignR(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignRFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignRFromGovSteamFV2Event.class)
  public void handle(UnAssignRFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignRFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignR(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignT1ToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignT1ToGovSteamFV2Event.class)
  public void handle(AssignT1ToGovSteamFV2Event event) {
    LOGGER.info("handling AssignT1ToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignT1(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteamFV2Event.class)
  public void handle(UnAssignT1FromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignT1FromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignT1(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignT3ToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignT3ToGovSteamFV2Event.class)
  public void handle(AssignT3ToGovSteamFV2Event event) {
    LOGGER.info("handling AssignT3ToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignT3(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignT3FromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovSteamFV2Event.class)
  public void handle(UnAssignT3FromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignT3FromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignT3(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignTaToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignTaToGovSteamFV2Event.class)
  public void handle(AssignTaToGovSteamFV2Event event) {
    LOGGER.info("handling AssignTaToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignTa(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignTaFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovSteamFV2Event.class)
  public void handle(UnAssignTaFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignTaFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignTa(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignTbToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignTbToGovSteamFV2Event.class)
  public void handle(AssignTbToGovSteamFV2Event event) {
    LOGGER.info("handling AssignTbToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignTb(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignTbFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignTbFromGovSteamFV2Event.class)
  public void handle(UnAssignTbFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignTbFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignTb(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignTcToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignTcToGovSteamFV2Event.class)
  public void handle(AssignTcToGovSteamFV2Event event) {
    LOGGER.info("handling AssignTcToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignTc(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignTcFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovSteamFV2Event.class)
  public void handle(UnAssignTcFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignTcFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignTc(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignTiToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignTiToGovSteamFV2Event.class)
  public void handle(AssignTiToGovSteamFV2Event event) {
    LOGGER.info("handling AssignTiToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignTi(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignTiFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignTiFromGovSteamFV2Event.class)
  public void handle(UnAssignTiFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignTiFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignTi(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignTtToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignTtToGovSteamFV2Event.class)
  public void handle(AssignTtToGovSteamFV2Event event) {
    LOGGER.info("handling AssignTtToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignTt(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignTtFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignTtFromGovSteamFV2Event.class)
  public void handle(UnAssignTtFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignTtFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignTt(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignVmaxToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignVmaxToGovSteamFV2Event.class)
  public void handle(AssignVmaxToGovSteamFV2Event event) {
    LOGGER.info("handling AssignVmaxToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignVmax(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignVmaxFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignVmaxFromGovSteamFV2Event.class)
  public void handle(UnAssignVmaxFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignVmaxFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignVmax(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event AssignVminToGovSteamFV2Event
   */
  @EventHandler(payloadType = AssignVminToGovSteamFV2Event.class)
  public void handle(AssignVminToGovSteamFV2Event event) {
    LOGGER.info("handling AssignVminToGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV2 entity = assignVmin(event.getGovSteamFV2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /*
   * @param	event UnAssignVminFromGovSteamFV2Event
   */
  @EventHandler(payloadType = UnAssignVminFromGovSteamFV2Event.class)
  public void handle(UnAssignVminFromGovSteamFV2Event event) {
    LOGGER.info("handling UnAssignVminFromGovSteamFV2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV2 entity = unAssignVmin(event.getGovSteamFV2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV2(entity);
  }

  /**
   * Method to retrieve the GovSteamFV2 via an GovSteamFV2PrimaryKey.
   *
   * @param id Long
   * @return GovSteamFV2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamFV2 handle(FindGovSteamFV2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamFV2Id());
  }

  /**
   * Method to retrieve a collection of all GovSteamFV2s
   *
   * @param query FindAllGovSteamFV2Query
   * @return List<GovSteamFV2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamFV2> handle(FindAllGovSteamFV2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamFV2, but only if the id matches
   *
   * @param entity GovSteamFV2
   */
  protected void emitFindGovSteamFV2(GovSteamFV2 entity) {
    LOGGER.info("handling emitFindGovSteamFV2");

    queryUpdateEmitter.emit(
        FindGovSteamFV2Query.class,
        query -> query.getFilter().getGovSteamFV2Id().equals(entity.getGovSteamFV2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamFV2
   *
   * @param entity GovSteamFV2
   */
  protected void emitFindAllGovSteamFV2(GovSteamFV2 entity) {
    LOGGER.info("handling emitFindAllGovSteamFV2");

    queryUpdateEmitter.emit(FindAllGovSteamFV2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamFV2Projector.class.getName());
}
