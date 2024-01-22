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
 * Projector for GovGAST1 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovGAST1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovGAST1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govGAST1")
@Component("govGAST1-projector")
public class GovGAST1Projector extends GovGAST1EntityProjector {

  // core constructor
  public GovGAST1Projector(GovGAST1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovGAST1Event
   */
  @EventHandler(payloadType = CreateGovGAST1Event.class)
  public void handle(CreateGovGAST1Event event) {
    LOGGER.info("handling CreateGovGAST1Event - " + event);
    GovGAST1 entity = new GovGAST1();
    entity.setGovGAST1Id(event.getGovGAST1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UpdateGovGAST1Event
   */
  @EventHandler(payloadType = UpdateGovGAST1Event.class)
  public void handle(UpdateGovGAST1Event event) {
    LOGGER.info("handling UpdateGovGAST1Event - " + event);

    GovGAST1 entity = new GovGAST1();
    entity.setGovGAST1Id(event.getGovGAST1Id());
    entity.setA(event.getA());
    entity.setB(event.getB());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setEps(event.getEps());
    entity.setFidle(event.getFidle());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setKa(event.getKa());
    entity.setKt(event.getKt());
    entity.setLmax(event.getLmax());
    entity.setLoadinc(event.getLoadinc());
    entity.setLtrate(event.getLtrate());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setR(event.getR());
    entity.setRmax(event.getRmax());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setTltr(event.getTltr());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event DeleteGovGAST1Event
   */
  @EventHandler(payloadType = DeleteGovGAST1Event.class)
  public void handle(DeleteGovGAST1Event event) {
    LOGGER.info("handling DeleteGovGAST1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovGAST1 entity = delete(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignAToGovGAST1Event
   */
  @EventHandler(payloadType = AssignAToGovGAST1Event.class)
  public void handle(AssignAToGovGAST1Event event) {
    LOGGER.info("handling AssignAToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignA(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignAFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignAFromGovGAST1Event.class)
  public void handle(UnAssignAFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignAFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignA(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignBToGovGAST1Event
   */
  @EventHandler(payloadType = AssignBToGovGAST1Event.class)
  public void handle(AssignBToGovGAST1Event event) {
    LOGGER.info("handling AssignBToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignB(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignBFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignBFromGovGAST1Event.class)
  public void handle(UnAssignBFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignBFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignB(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignDb1ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignDb1ToGovGAST1Event.class)
  public void handle(AssignDb1ToGovGAST1Event event) {
    LOGGER.info("handling AssignDb1ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignDb1(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignDb1FromGovGAST1Event.class)
  public void handle(UnAssignDb1FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignDb1FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignDb1(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignDb2ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignDb2ToGovGAST1Event.class)
  public void handle(AssignDb2ToGovGAST1Event event) {
    LOGGER.info("handling AssignDb2ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignDb2(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignDb2FromGovGAST1Event.class)
  public void handle(UnAssignDb2FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignDb2FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignDb2(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignEpsToGovGAST1Event
   */
  @EventHandler(payloadType = AssignEpsToGovGAST1Event.class)
  public void handle(AssignEpsToGovGAST1Event event) {
    LOGGER.info("handling AssignEpsToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignEps(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignEpsFromGovGAST1Event.class)
  public void handle(UnAssignEpsFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignEpsFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignEps(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignFidleToGovGAST1Event
   */
  @EventHandler(payloadType = AssignFidleToGovGAST1Event.class)
  public void handle(AssignFidleToGovGAST1Event event) {
    LOGGER.info("handling AssignFidleToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignFidle(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignFidleFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignFidleFromGovGAST1Event.class)
  public void handle(UnAssignFidleFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignFidleFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignFidle(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignGv1ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignGv1ToGovGAST1Event.class)
  public void handle(AssignGv1ToGovGAST1Event event) {
    LOGGER.info("handling AssignGv1ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignGv1(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignGv1FromGovGAST1Event.class)
  public void handle(UnAssignGv1FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignGv1FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignGv1(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignGv2ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignGv2ToGovGAST1Event.class)
  public void handle(AssignGv2ToGovGAST1Event event) {
    LOGGER.info("handling AssignGv2ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignGv2(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignGv2FromGovGAST1Event.class)
  public void handle(UnAssignGv2FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignGv2FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignGv2(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignGv3ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignGv3ToGovGAST1Event.class)
  public void handle(AssignGv3ToGovGAST1Event event) {
    LOGGER.info("handling AssignGv3ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignGv3(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignGv3FromGovGAST1Event.class)
  public void handle(UnAssignGv3FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignGv3FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignGv3(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignGv4ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignGv4ToGovGAST1Event.class)
  public void handle(AssignGv4ToGovGAST1Event event) {
    LOGGER.info("handling AssignGv4ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignGv4(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignGv4FromGovGAST1Event.class)
  public void handle(UnAssignGv4FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignGv4FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignGv4(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignGv5ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignGv5ToGovGAST1Event.class)
  public void handle(AssignGv5ToGovGAST1Event event) {
    LOGGER.info("handling AssignGv5ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignGv5(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignGv5FromGovGAST1Event.class)
  public void handle(UnAssignGv5FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignGv5FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignGv5(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignGv6ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignGv6ToGovGAST1Event.class)
  public void handle(AssignGv6ToGovGAST1Event event) {
    LOGGER.info("handling AssignGv6ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignGv6(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignGv6FromGovGAST1Event.class)
  public void handle(UnAssignGv6FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignGv6FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignGv6(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignKaToGovGAST1Event
   */
  @EventHandler(payloadType = AssignKaToGovGAST1Event.class)
  public void handle(AssignKaToGovGAST1Event event) {
    LOGGER.info("handling AssignKaToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignKa(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignKaFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignKaFromGovGAST1Event.class)
  public void handle(UnAssignKaFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignKaFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignKa(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignKtToGovGAST1Event
   */
  @EventHandler(payloadType = AssignKtToGovGAST1Event.class)
  public void handle(AssignKtToGovGAST1Event event) {
    LOGGER.info("handling AssignKtToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignKt(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignKtFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignKtFromGovGAST1Event.class)
  public void handle(UnAssignKtFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignKtFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignKt(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignLmaxToGovGAST1Event
   */
  @EventHandler(payloadType = AssignLmaxToGovGAST1Event.class)
  public void handle(AssignLmaxToGovGAST1Event event) {
    LOGGER.info("handling AssignLmaxToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignLmax(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignLmaxFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignLmaxFromGovGAST1Event.class)
  public void handle(UnAssignLmaxFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignLmaxFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignLmax(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignLoadincToGovGAST1Event
   */
  @EventHandler(payloadType = AssignLoadincToGovGAST1Event.class)
  public void handle(AssignLoadincToGovGAST1Event event) {
    LOGGER.info("handling AssignLoadincToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignLoadinc(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignLoadincFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignLoadincFromGovGAST1Event.class)
  public void handle(UnAssignLoadincFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignLoadincFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignLoadinc(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignLtrateToGovGAST1Event
   */
  @EventHandler(payloadType = AssignLtrateToGovGAST1Event.class)
  public void handle(AssignLtrateToGovGAST1Event event) {
    LOGGER.info("handling AssignLtrateToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignLtrate(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignLtrateFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignLtrateFromGovGAST1Event.class)
  public void handle(UnAssignLtrateFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignLtrateFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignLtrate(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignMwbaseToGovGAST1Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovGAST1Event.class)
  public void handle(AssignMwbaseToGovGAST1Event event) {
    LOGGER.info("handling AssignMwbaseToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignMwbase(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovGAST1Event.class)
  public void handle(UnAssignMwbaseFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignMwbase(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignPgv1ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignPgv1ToGovGAST1Event.class)
  public void handle(AssignPgv1ToGovGAST1Event event) {
    LOGGER.info("handling AssignPgv1ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignPgv1(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovGAST1Event.class)
  public void handle(UnAssignPgv1FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignPgv1FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignPgv1(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignPgv2ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignPgv2ToGovGAST1Event.class)
  public void handle(AssignPgv2ToGovGAST1Event event) {
    LOGGER.info("handling AssignPgv2ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignPgv2(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovGAST1Event.class)
  public void handle(UnAssignPgv2FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignPgv2FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignPgv2(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignPgv3ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignPgv3ToGovGAST1Event.class)
  public void handle(AssignPgv3ToGovGAST1Event event) {
    LOGGER.info("handling AssignPgv3ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignPgv3(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovGAST1Event.class)
  public void handle(UnAssignPgv3FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignPgv3FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignPgv3(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignPgv4ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignPgv4ToGovGAST1Event.class)
  public void handle(AssignPgv4ToGovGAST1Event event) {
    LOGGER.info("handling AssignPgv4ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignPgv4(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovGAST1Event.class)
  public void handle(UnAssignPgv4FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignPgv4FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignPgv4(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignPgv5ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignPgv5ToGovGAST1Event.class)
  public void handle(AssignPgv5ToGovGAST1Event event) {
    LOGGER.info("handling AssignPgv5ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignPgv5(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovGAST1Event.class)
  public void handle(UnAssignPgv5FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignPgv5FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignPgv5(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignPgv6ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignPgv6ToGovGAST1Event.class)
  public void handle(AssignPgv6ToGovGAST1Event event) {
    LOGGER.info("handling AssignPgv6ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignPgv6(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovGAST1Event.class)
  public void handle(UnAssignPgv6FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignPgv6FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignPgv6(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignRToGovGAST1Event
   */
  @EventHandler(payloadType = AssignRToGovGAST1Event.class)
  public void handle(AssignRToGovGAST1Event event) {
    LOGGER.info("handling AssignRToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignR(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignRFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignRFromGovGAST1Event.class)
  public void handle(UnAssignRFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignRFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignR(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignRmaxToGovGAST1Event
   */
  @EventHandler(payloadType = AssignRmaxToGovGAST1Event.class)
  public void handle(AssignRmaxToGovGAST1Event event) {
    LOGGER.info("handling AssignRmaxToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignRmax(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignRmaxFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignRmaxFromGovGAST1Event.class)
  public void handle(UnAssignRmaxFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignRmaxFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignRmax(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignT1ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignT1ToGovGAST1Event.class)
  public void handle(AssignT1ToGovGAST1Event event) {
    LOGGER.info("handling AssignT1ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignT1(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignT1FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovGAST1Event.class)
  public void handle(UnAssignT1FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignT1FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignT1(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignT2ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignT2ToGovGAST1Event.class)
  public void handle(AssignT2ToGovGAST1Event event) {
    LOGGER.info("handling AssignT2ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignT2(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignT2FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovGAST1Event.class)
  public void handle(UnAssignT2FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignT2FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignT2(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignT3ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignT3ToGovGAST1Event.class)
  public void handle(AssignT3ToGovGAST1Event event) {
    LOGGER.info("handling AssignT3ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignT3(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignT3FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovGAST1Event.class)
  public void handle(UnAssignT3FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignT3FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignT3(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignT4ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignT4ToGovGAST1Event.class)
  public void handle(AssignT4ToGovGAST1Event event) {
    LOGGER.info("handling AssignT4ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignT4(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignT4FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignT4FromGovGAST1Event.class)
  public void handle(UnAssignT4FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignT4FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignT4(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignT5ToGovGAST1Event
   */
  @EventHandler(payloadType = AssignT5ToGovGAST1Event.class)
  public void handle(AssignT5ToGovGAST1Event event) {
    LOGGER.info("handling AssignT5ToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignT5(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignT5FromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignT5FromGovGAST1Event.class)
  public void handle(UnAssignT5FromGovGAST1Event event) {
    LOGGER.info("handling UnAssignT5FromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignT5(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignTltrToGovGAST1Event
   */
  @EventHandler(payloadType = AssignTltrToGovGAST1Event.class)
  public void handle(AssignTltrToGovGAST1Event event) {
    LOGGER.info("handling AssignTltrToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignTltr(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignTltrFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignTltrFromGovGAST1Event.class)
  public void handle(UnAssignTltrFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignTltrFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignTltr(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignVmaxToGovGAST1Event
   */
  @EventHandler(payloadType = AssignVmaxToGovGAST1Event.class)
  public void handle(AssignVmaxToGovGAST1Event event) {
    LOGGER.info("handling AssignVmaxToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignVmax(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignVmaxFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignVmaxFromGovGAST1Event.class)
  public void handle(UnAssignVmaxFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignVmaxFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignVmax(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event AssignVminToGovGAST1Event
   */
  @EventHandler(payloadType = AssignVminToGovGAST1Event.class)
  public void handle(AssignVminToGovGAST1Event event) {
    LOGGER.info("handling AssignVminToGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST1 entity = assignVmin(event.getGovGAST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /*
   * @param	event UnAssignVminFromGovGAST1Event
   */
  @EventHandler(payloadType = UnAssignVminFromGovGAST1Event.class)
  public void handle(UnAssignVminFromGovGAST1Event event) {
    LOGGER.info("handling UnAssignVminFromGovGAST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST1 entity = unAssignVmin(event.getGovGAST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST1(entity);
  }

  /**
   * Method to retrieve the GovGAST1 via an GovGAST1PrimaryKey.
   *
   * @param id Long
   * @return GovGAST1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovGAST1 handle(FindGovGAST1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovGAST1Id());
  }

  /**
   * Method to retrieve a collection of all GovGAST1s
   *
   * @param query FindAllGovGAST1Query
   * @return List<GovGAST1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovGAST1> handle(FindAllGovGAST1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovGAST1, but only if the id matches
   *
   * @param entity GovGAST1
   */
  protected void emitFindGovGAST1(GovGAST1 entity) {
    LOGGER.info("handling emitFindGovGAST1");

    queryUpdateEmitter.emit(
        FindGovGAST1Query.class,
        query -> query.getFilter().getGovGAST1Id().equals(entity.getGovGAST1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovGAST1
   *
   * @param entity GovGAST1
   */
  protected void emitFindAllGovGAST1(GovGAST1 entity) {
    LOGGER.info("handling emitFindAllGovGAST1");

    queryUpdateEmitter.emit(FindAllGovGAST1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovGAST1Projector.class.getName());
}
