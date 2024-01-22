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
 * Projector for GovHydro2 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydro2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydro2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydro2")
@Component("govHydro2-projector")
public class GovHydro2Projector extends GovHydro2EntityProjector {

  // core constructor
  public GovHydro2Projector(GovHydro2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydro2Event
   */
  @EventHandler(payloadType = CreateGovHydro2Event.class)
  public void handle(CreateGovHydro2Event event) {
    LOGGER.info("handling CreateGovHydro2Event - " + event);
    GovHydro2 entity = new GovHydro2();
    entity.setGovHydro2Id(event.getGovHydro2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UpdateGovHydro2Event
   */
  @EventHandler(payloadType = UpdateGovHydro2Event.class)
  public void handle(UpdateGovHydro2Event event) {
    LOGGER.info("handling UpdateGovHydro2Event - " + event);

    GovHydro2 entity = new GovHydro2();
    entity.setGovHydro2Id(event.getGovHydro2Id());
    entity.setAturb(event.getAturb());
    entity.setBturb(event.getBturb());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setEps(event.getEps());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setKturb(event.getKturb());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setRperm(event.getRperm());
    entity.setRtemp(event.getRtemp());
    entity.setTg(event.getTg());
    entity.setTp(event.getTp());
    entity.setTr(event.getTr());
    entity.setTw(event.getTw());
    entity.setUc(event.getUc());
    entity.setUo(event.getUo());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event DeleteGovHydro2Event
   */
  @EventHandler(payloadType = DeleteGovHydro2Event.class)
  public void handle(DeleteGovHydro2Event event) {
    LOGGER.info("handling DeleteGovHydro2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydro2 entity = delete(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignAturbToGovHydro2Event
   */
  @EventHandler(payloadType = AssignAturbToGovHydro2Event.class)
  public void handle(AssignAturbToGovHydro2Event event) {
    LOGGER.info("handling AssignAturbToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignAturb(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignAturbFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignAturbFromGovHydro2Event.class)
  public void handle(UnAssignAturbFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignAturbFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignAturb(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignBturbToGovHydro2Event
   */
  @EventHandler(payloadType = AssignBturbToGovHydro2Event.class)
  public void handle(AssignBturbToGovHydro2Event event) {
    LOGGER.info("handling AssignBturbToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignBturb(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignBturbFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignBturbFromGovHydro2Event.class)
  public void handle(UnAssignBturbFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignBturbFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignBturb(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignDb1ToGovHydro2Event.class)
  public void handle(AssignDb1ToGovHydro2Event event) {
    LOGGER.info("handling AssignDb1ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignDb1(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydro2Event.class)
  public void handle(UnAssignDb1FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignDb1FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignDb1(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignDb2ToGovHydro2Event.class)
  public void handle(AssignDb2ToGovHydro2Event event) {
    LOGGER.info("handling AssignDb2ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignDb2(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydro2Event.class)
  public void handle(UnAssignDb2FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignDb2FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignDb2(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignEpsToGovHydro2Event
   */
  @EventHandler(payloadType = AssignEpsToGovHydro2Event.class)
  public void handle(AssignEpsToGovHydro2Event event) {
    LOGGER.info("handling AssignEpsToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignEps(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignEpsFromGovHydro2Event.class)
  public void handle(UnAssignEpsFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignEpsFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignEps(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignGv1ToGovHydro2Event.class)
  public void handle(AssignGv1ToGovHydro2Event event) {
    LOGGER.info("handling AssignGv1ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignGv1(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydro2Event.class)
  public void handle(UnAssignGv1FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignGv1FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignGv1(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignGv2ToGovHydro2Event.class)
  public void handle(AssignGv2ToGovHydro2Event event) {
    LOGGER.info("handling AssignGv2ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignGv2(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydro2Event.class)
  public void handle(UnAssignGv2FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignGv2FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignGv2(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignGv3ToGovHydro2Event.class)
  public void handle(AssignGv3ToGovHydro2Event event) {
    LOGGER.info("handling AssignGv3ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignGv3(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydro2Event.class)
  public void handle(UnAssignGv3FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignGv3FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignGv3(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignGv4ToGovHydro2Event.class)
  public void handle(AssignGv4ToGovHydro2Event event) {
    LOGGER.info("handling AssignGv4ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignGv4(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydro2Event.class)
  public void handle(UnAssignGv4FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignGv4FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignGv4(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignGv5ToGovHydro2Event.class)
  public void handle(AssignGv5ToGovHydro2Event event) {
    LOGGER.info("handling AssignGv5ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignGv5(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydro2Event.class)
  public void handle(UnAssignGv5FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignGv5FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignGv5(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignGv6ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignGv6ToGovHydro2Event.class)
  public void handle(AssignGv6ToGovHydro2Event event) {
    LOGGER.info("handling AssignGv6ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignGv6(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignGv6FromGovHydro2Event.class)
  public void handle(UnAssignGv6FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignGv6FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignGv6(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignKturbToGovHydro2Event
   */
  @EventHandler(payloadType = AssignKturbToGovHydro2Event.class)
  public void handle(AssignKturbToGovHydro2Event event) {
    LOGGER.info("handling AssignKturbToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignKturb(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignKturbFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignKturbFromGovHydro2Event.class)
  public void handle(UnAssignKturbFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignKturbFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignKturb(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydro2Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydro2Event.class)
  public void handle(AssignMwbaseToGovHydro2Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignMwbase(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydro2Event.class)
  public void handle(UnAssignMwbaseFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignMwbase(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydro2Event.class)
  public void handle(AssignPgv1ToGovHydro2Event event) {
    LOGGER.info("handling AssignPgv1ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPgv1(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydro2Event.class)
  public void handle(UnAssignPgv1FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPgv1(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydro2Event.class)
  public void handle(AssignPgv2ToGovHydro2Event event) {
    LOGGER.info("handling AssignPgv2ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPgv2(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydro2Event.class)
  public void handle(UnAssignPgv2FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPgv2(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydro2Event.class)
  public void handle(AssignPgv3ToGovHydro2Event event) {
    LOGGER.info("handling AssignPgv3ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPgv3(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydro2Event.class)
  public void handle(UnAssignPgv3FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPgv3(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydro2Event.class)
  public void handle(AssignPgv4ToGovHydro2Event event) {
    LOGGER.info("handling AssignPgv4ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPgv4(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydro2Event.class)
  public void handle(UnAssignPgv4FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPgv4(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydro2Event.class)
  public void handle(AssignPgv5ToGovHydro2Event event) {
    LOGGER.info("handling AssignPgv5ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPgv5(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydro2Event.class)
  public void handle(UnAssignPgv5FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPgv5(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPgv6ToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPgv6ToGovHydro2Event.class)
  public void handle(AssignPgv6ToGovHydro2Event event) {
    LOGGER.info("handling AssignPgv6ToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPgv6(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovHydro2Event.class)
  public void handle(UnAssignPgv6FromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPgv6FromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPgv6(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPmaxToGovHydro2Event.class)
  public void handle(AssignPmaxToGovHydro2Event event) {
    LOGGER.info("handling AssignPmaxToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPmax(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydro2Event.class)
  public void handle(UnAssignPmaxFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPmax(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignPminToGovHydro2Event
   */
  @EventHandler(payloadType = AssignPminToGovHydro2Event.class)
  public void handle(AssignPminToGovHydro2Event event) {
    LOGGER.info("handling AssignPminToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignPmin(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydro2Event.class)
  public void handle(UnAssignPminFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignPminFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignPmin(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignRpermToGovHydro2Event
   */
  @EventHandler(payloadType = AssignRpermToGovHydro2Event.class)
  public void handle(AssignRpermToGovHydro2Event event) {
    LOGGER.info("handling AssignRpermToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignRperm(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignRpermFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignRpermFromGovHydro2Event.class)
  public void handle(UnAssignRpermFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignRpermFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignRperm(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignRtempToGovHydro2Event
   */
  @EventHandler(payloadType = AssignRtempToGovHydro2Event.class)
  public void handle(AssignRtempToGovHydro2Event event) {
    LOGGER.info("handling AssignRtempToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignRtemp(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignRtempFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignRtempFromGovHydro2Event.class)
  public void handle(UnAssignRtempFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignRtempFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignRtemp(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignTgToGovHydro2Event
   */
  @EventHandler(payloadType = AssignTgToGovHydro2Event.class)
  public void handle(AssignTgToGovHydro2Event event) {
    LOGGER.info("handling AssignTgToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignTg(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignTgFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignTgFromGovHydro2Event.class)
  public void handle(UnAssignTgFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignTgFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignTg(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignTpToGovHydro2Event
   */
  @EventHandler(payloadType = AssignTpToGovHydro2Event.class)
  public void handle(AssignTpToGovHydro2Event event) {
    LOGGER.info("handling AssignTpToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignTp(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydro2Event.class)
  public void handle(UnAssignTpFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignTpFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignTp(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignTrToGovHydro2Event
   */
  @EventHandler(payloadType = AssignTrToGovHydro2Event.class)
  public void handle(AssignTrToGovHydro2Event event) {
    LOGGER.info("handling AssignTrToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignTr(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignTrFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignTrFromGovHydro2Event.class)
  public void handle(UnAssignTrFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignTrFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignTr(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignTwToGovHydro2Event
   */
  @EventHandler(payloadType = AssignTwToGovHydro2Event.class)
  public void handle(AssignTwToGovHydro2Event event) {
    LOGGER.info("handling AssignTwToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignTw(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydro2Event.class)
  public void handle(UnAssignTwFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignTwFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignTw(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignUcToGovHydro2Event
   */
  @EventHandler(payloadType = AssignUcToGovHydro2Event.class)
  public void handle(AssignUcToGovHydro2Event event) {
    LOGGER.info("handling AssignUcToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignUc(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignUcFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignUcFromGovHydro2Event.class)
  public void handle(UnAssignUcFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignUcFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignUc(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event AssignUoToGovHydro2Event
   */
  @EventHandler(payloadType = AssignUoToGovHydro2Event.class)
  public void handle(AssignUoToGovHydro2Event event) {
    LOGGER.info("handling AssignUoToGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro2 entity = assignUo(event.getGovHydro2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /*
   * @param	event UnAssignUoFromGovHydro2Event
   */
  @EventHandler(payloadType = UnAssignUoFromGovHydro2Event.class)
  public void handle(UnAssignUoFromGovHydro2Event event) {
    LOGGER.info("handling UnAssignUoFromGovHydro2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro2 entity = unAssignUo(event.getGovHydro2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro2(entity);
  }

  /**
   * Method to retrieve the GovHydro2 via an GovHydro2PrimaryKey.
   *
   * @param id Long
   * @return GovHydro2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydro2 handle(FindGovHydro2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydro2Id());
  }

  /**
   * Method to retrieve a collection of all GovHydro2s
   *
   * @param query FindAllGovHydro2Query
   * @return List<GovHydro2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydro2> handle(FindAllGovHydro2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydro2, but only if the id matches
   *
   * @param entity GovHydro2
   */
  protected void emitFindGovHydro2(GovHydro2 entity) {
    LOGGER.info("handling emitFindGovHydro2");

    queryUpdateEmitter.emit(
        FindGovHydro2Query.class,
        query -> query.getFilter().getGovHydro2Id().equals(entity.getGovHydro2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydro2
   *
   * @param entity GovHydro2
   */
  protected void emitFindAllGovHydro2(GovHydro2 entity) {
    LOGGER.info("handling emitFindAllGovHydro2");

    queryUpdateEmitter.emit(FindAllGovHydro2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydro2Projector.class.getName());
}
