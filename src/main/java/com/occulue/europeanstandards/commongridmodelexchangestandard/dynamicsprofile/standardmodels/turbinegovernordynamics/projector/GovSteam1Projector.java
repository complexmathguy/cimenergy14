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
 * Projector for GovSteam1 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteam1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteam1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteam1")
@Component("govSteam1-projector")
public class GovSteam1Projector extends GovSteam1EntityProjector {

  // core constructor
  public GovSteam1Projector(GovSteam1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteam1Event
   */
  @EventHandler(payloadType = CreateGovSteam1Event.class)
  public void handle(CreateGovSteam1Event event) {
    LOGGER.info("handling CreateGovSteam1Event - " + event);
    GovSteam1 entity = new GovSteam1();
    entity.setGovSteam1Id(event.getGovSteam1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UpdateGovSteam1Event
   */
  @EventHandler(payloadType = UpdateGovSteam1Event.class)
  public void handle(UpdateGovSteam1Event event) {
    LOGGER.info("handling UpdateGovSteam1Event - " + event);

    GovSteam1 entity = new GovSteam1();
    entity.setGovSteam1Id(event.getGovSteam1Id());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setEps(event.getEps());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setK(event.getK());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setK4(event.getK4());
    entity.setK5(event.getK5());
    entity.setK6(event.getK6());
    entity.setK7(event.getK7());
    entity.setK8(event.getK8());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setSdb1(event.getSdb1());
    entity.setSdb2(event.getSdb2());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setUc(event.getUc());
    entity.setUo(event.getUo());
    entity.setValve(event.getValve());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event DeleteGovSteam1Event
   */
  @EventHandler(payloadType = DeleteGovSteam1Event.class)
  public void handle(DeleteGovSteam1Event event) {
    LOGGER.info("handling DeleteGovSteam1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteam1 entity = delete(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignDb1ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignDb1ToGovSteam1Event.class)
  public void handle(AssignDb1ToGovSteam1Event event) {
    LOGGER.info("handling AssignDb1ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignDb1(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignDb1FromGovSteam1Event.class)
  public void handle(UnAssignDb1FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignDb1FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignDb1(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignDb2ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignDb2ToGovSteam1Event.class)
  public void handle(AssignDb2ToGovSteam1Event event) {
    LOGGER.info("handling AssignDb2ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignDb2(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignDb2FromGovSteam1Event.class)
  public void handle(UnAssignDb2FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignDb2FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignDb2(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignEpsToGovSteam1Event
   */
  @EventHandler(payloadType = AssignEpsToGovSteam1Event.class)
  public void handle(AssignEpsToGovSteam1Event event) {
    LOGGER.info("handling AssignEpsToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignEps(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignEpsFromGovSteam1Event.class)
  public void handle(UnAssignEpsFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignEpsFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignEps(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignGv1ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignGv1ToGovSteam1Event.class)
  public void handle(AssignGv1ToGovSteam1Event event) {
    LOGGER.info("handling AssignGv1ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignGv1(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignGv1FromGovSteam1Event.class)
  public void handle(UnAssignGv1FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignGv1FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignGv1(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignGv2ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignGv2ToGovSteam1Event.class)
  public void handle(AssignGv2ToGovSteam1Event event) {
    LOGGER.info("handling AssignGv2ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignGv2(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignGv2FromGovSteam1Event.class)
  public void handle(UnAssignGv2FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignGv2FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignGv2(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignGv3ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignGv3ToGovSteam1Event.class)
  public void handle(AssignGv3ToGovSteam1Event event) {
    LOGGER.info("handling AssignGv3ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignGv3(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignGv3FromGovSteam1Event.class)
  public void handle(UnAssignGv3FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignGv3FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignGv3(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignGv4ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignGv4ToGovSteam1Event.class)
  public void handle(AssignGv4ToGovSteam1Event event) {
    LOGGER.info("handling AssignGv4ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignGv4(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignGv4FromGovSteam1Event.class)
  public void handle(UnAssignGv4FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignGv4FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignGv4(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignGv5ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignGv5ToGovSteam1Event.class)
  public void handle(AssignGv5ToGovSteam1Event event) {
    LOGGER.info("handling AssignGv5ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignGv5(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignGv5FromGovSteam1Event.class)
  public void handle(UnAssignGv5FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignGv5FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignGv5(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignGv6ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignGv6ToGovSteam1Event.class)
  public void handle(AssignGv6ToGovSteam1Event event) {
    LOGGER.info("handling AssignGv6ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignGv6(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignGv6FromGovSteam1Event.class)
  public void handle(UnAssignGv6FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignGv6FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignGv6(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignKToGovSteam1Event
   */
  @EventHandler(payloadType = AssignKToGovSteam1Event.class)
  public void handle(AssignKToGovSteam1Event event) {
    LOGGER.info("handling AssignKToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignKFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignKFromGovSteam1Event.class)
  public void handle(UnAssignKFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignKFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK1ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK1ToGovSteam1Event.class)
  public void handle(AssignK1ToGovSteam1Event event) {
    LOGGER.info("handling AssignK1ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK1(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK1FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK1FromGovSteam1Event.class)
  public void handle(UnAssignK1FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK1FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK1(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK2ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK2ToGovSteam1Event.class)
  public void handle(AssignK2ToGovSteam1Event event) {
    LOGGER.info("handling AssignK2ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK2(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK2FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK2FromGovSteam1Event.class)
  public void handle(UnAssignK2FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK2FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK2(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK3ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK3ToGovSteam1Event.class)
  public void handle(AssignK3ToGovSteam1Event event) {
    LOGGER.info("handling AssignK3ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK3(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK3FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK3FromGovSteam1Event.class)
  public void handle(UnAssignK3FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK3FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK3(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK4ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK4ToGovSteam1Event.class)
  public void handle(AssignK4ToGovSteam1Event event) {
    LOGGER.info("handling AssignK4ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK4(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK4FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK4FromGovSteam1Event.class)
  public void handle(UnAssignK4FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK4FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK4(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK5ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK5ToGovSteam1Event.class)
  public void handle(AssignK5ToGovSteam1Event event) {
    LOGGER.info("handling AssignK5ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK5(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK5FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK5FromGovSteam1Event.class)
  public void handle(UnAssignK5FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK5FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK5(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK6ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK6ToGovSteam1Event.class)
  public void handle(AssignK6ToGovSteam1Event event) {
    LOGGER.info("handling AssignK6ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK6(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK6FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK6FromGovSteam1Event.class)
  public void handle(UnAssignK6FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK6FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK6(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK7ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK7ToGovSteam1Event.class)
  public void handle(AssignK7ToGovSteam1Event event) {
    LOGGER.info("handling AssignK7ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK7(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK7FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK7FromGovSteam1Event.class)
  public void handle(UnAssignK7FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK7FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK7(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignK8ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignK8ToGovSteam1Event.class)
  public void handle(AssignK8ToGovSteam1Event event) {
    LOGGER.info("handling AssignK8ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignK8(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignK8FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignK8FromGovSteam1Event.class)
  public void handle(UnAssignK8FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignK8FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignK8(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteam1Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteam1Event.class)
  public void handle(AssignMwbaseToGovSteam1Event event) {
    LOGGER.info("handling AssignMwbaseToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignMwbase(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteam1Event.class)
  public void handle(UnAssignMwbaseFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignMwbase(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPgv1ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPgv1ToGovSteam1Event.class)
  public void handle(AssignPgv1ToGovSteam1Event event) {
    LOGGER.info("handling AssignPgv1ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPgv1(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovSteam1Event.class)
  public void handle(UnAssignPgv1FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPgv1FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPgv1(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPgv2ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPgv2ToGovSteam1Event.class)
  public void handle(AssignPgv2ToGovSteam1Event event) {
    LOGGER.info("handling AssignPgv2ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPgv2(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovSteam1Event.class)
  public void handle(UnAssignPgv2FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPgv2FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPgv2(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPgv3ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPgv3ToGovSteam1Event.class)
  public void handle(AssignPgv3ToGovSteam1Event event) {
    LOGGER.info("handling AssignPgv3ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPgv3(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovSteam1Event.class)
  public void handle(UnAssignPgv3FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPgv3FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPgv3(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPgv4ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPgv4ToGovSteam1Event.class)
  public void handle(AssignPgv4ToGovSteam1Event event) {
    LOGGER.info("handling AssignPgv4ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPgv4(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovSteam1Event.class)
  public void handle(UnAssignPgv4FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPgv4FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPgv4(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPgv5ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPgv5ToGovSteam1Event.class)
  public void handle(AssignPgv5ToGovSteam1Event event) {
    LOGGER.info("handling AssignPgv5ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPgv5(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovSteam1Event.class)
  public void handle(UnAssignPgv5FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPgv5FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPgv5(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPgv6ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPgv6ToGovSteam1Event.class)
  public void handle(AssignPgv6ToGovSteam1Event event) {
    LOGGER.info("handling AssignPgv6ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPgv6(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovSteam1Event.class)
  public void handle(UnAssignPgv6FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPgv6FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPgv6(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPmaxToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPmaxToGovSteam1Event.class)
  public void handle(AssignPmaxToGovSteam1Event event) {
    LOGGER.info("handling AssignPmaxToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPmax(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovSteam1Event.class)
  public void handle(UnAssignPmaxFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPmax(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignPminToGovSteam1Event
   */
  @EventHandler(payloadType = AssignPminToGovSteam1Event.class)
  public void handle(AssignPminToGovSteam1Event event) {
    LOGGER.info("handling AssignPminToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignPmin(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignPminFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovSteam1Event.class)
  public void handle(UnAssignPminFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignPminFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignPmin(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignSdb1ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignSdb1ToGovSteam1Event.class)
  public void handle(AssignSdb1ToGovSteam1Event event) {
    LOGGER.info("handling AssignSdb1ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignSdb1(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignSdb1FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignSdb1FromGovSteam1Event.class)
  public void handle(UnAssignSdb1FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignSdb1FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignSdb1(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignSdb2ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignSdb2ToGovSteam1Event.class)
  public void handle(AssignSdb2ToGovSteam1Event event) {
    LOGGER.info("handling AssignSdb2ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignSdb2(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignSdb2FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignSdb2FromGovSteam1Event.class)
  public void handle(UnAssignSdb2FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignSdb2FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignSdb2(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT1ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT1ToGovSteam1Event.class)
  public void handle(AssignT1ToGovSteam1Event event) {
    LOGGER.info("handling AssignT1ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT1(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteam1Event.class)
  public void handle(UnAssignT1FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT1FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT1(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT2ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT2ToGovSteam1Event.class)
  public void handle(AssignT2ToGovSteam1Event event) {
    LOGGER.info("handling AssignT2ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT2(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT2FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovSteam1Event.class)
  public void handle(UnAssignT2FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT2FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT2(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT3ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT3ToGovSteam1Event.class)
  public void handle(AssignT3ToGovSteam1Event event) {
    LOGGER.info("handling AssignT3ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT3(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT3FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovSteam1Event.class)
  public void handle(UnAssignT3FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT3FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT3(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT4ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT4ToGovSteam1Event.class)
  public void handle(AssignT4ToGovSteam1Event event) {
    LOGGER.info("handling AssignT4ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT4(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT4FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT4FromGovSteam1Event.class)
  public void handle(UnAssignT4FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT4FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT4(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT5ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT5ToGovSteam1Event.class)
  public void handle(AssignT5ToGovSteam1Event event) {
    LOGGER.info("handling AssignT5ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT5(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT5FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT5FromGovSteam1Event.class)
  public void handle(UnAssignT5FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT5FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT5(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT6ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT6ToGovSteam1Event.class)
  public void handle(AssignT6ToGovSteam1Event event) {
    LOGGER.info("handling AssignT6ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT6(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT6FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT6FromGovSteam1Event.class)
  public void handle(UnAssignT6FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT6FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT6(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignT7ToGovSteam1Event
   */
  @EventHandler(payloadType = AssignT7ToGovSteam1Event.class)
  public void handle(AssignT7ToGovSteam1Event event) {
    LOGGER.info("handling AssignT7ToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignT7(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignT7FromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignT7FromGovSteam1Event.class)
  public void handle(UnAssignT7FromGovSteam1Event event) {
    LOGGER.info("handling UnAssignT7FromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignT7(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignUcToGovSteam1Event
   */
  @EventHandler(payloadType = AssignUcToGovSteam1Event.class)
  public void handle(AssignUcToGovSteam1Event event) {
    LOGGER.info("handling AssignUcToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignUc(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignUcFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignUcFromGovSteam1Event.class)
  public void handle(UnAssignUcFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignUcFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignUc(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignUoToGovSteam1Event
   */
  @EventHandler(payloadType = AssignUoToGovSteam1Event.class)
  public void handle(AssignUoToGovSteam1Event event) {
    LOGGER.info("handling AssignUoToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignUo(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignUoFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignUoFromGovSteam1Event.class)
  public void handle(UnAssignUoFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignUoFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignUo(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event AssignValveToGovSteam1Event
   */
  @EventHandler(payloadType = AssignValveToGovSteam1Event.class)
  public void handle(AssignValveToGovSteam1Event event) {
    LOGGER.info("handling AssignValveToGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam1 entity = assignValve(event.getGovSteam1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /*
   * @param	event UnAssignValveFromGovSteam1Event
   */
  @EventHandler(payloadType = UnAssignValveFromGovSteam1Event.class)
  public void handle(UnAssignValveFromGovSteam1Event event) {
    LOGGER.info("handling UnAssignValveFromGovSteam1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam1 entity = unAssignValve(event.getGovSteam1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam1(entity);
  }

  /**
   * Method to retrieve the GovSteam1 via an GovSteam1PrimaryKey.
   *
   * @param id Long
   * @return GovSteam1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteam1 handle(FindGovSteam1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteam1Id());
  }

  /**
   * Method to retrieve a collection of all GovSteam1s
   *
   * @param query FindAllGovSteam1Query
   * @return List<GovSteam1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteam1> handle(FindAllGovSteam1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteam1, but only if the id matches
   *
   * @param entity GovSteam1
   */
  protected void emitFindGovSteam1(GovSteam1 entity) {
    LOGGER.info("handling emitFindGovSteam1");

    queryUpdateEmitter.emit(
        FindGovSteam1Query.class,
        query -> query.getFilter().getGovSteam1Id().equals(entity.getGovSteam1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteam1
   *
   * @param entity GovSteam1
   */
  protected void emitFindAllGovSteam1(GovSteam1 entity) {
    LOGGER.info("handling emitFindAllGovSteam1");

    queryUpdateEmitter.emit(FindAllGovSteam1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteam1Projector.class.getName());
}
