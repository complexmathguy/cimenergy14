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
 * Projector for GovGASTWD as outlined for the CQRS pattern. All event handling and query handling
 * related to GovGASTWD are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovGASTWDAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govGASTWD")
@Component("govGASTWD-projector")
public class GovGASTWDProjector extends GovGASTWDEntityProjector {

  // core constructor
  public GovGASTWDProjector(GovGASTWDRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovGASTWDEvent
   */
  @EventHandler(payloadType = CreateGovGASTWDEvent.class)
  public void handle(CreateGovGASTWDEvent event) {
    LOGGER.info("handling CreateGovGASTWDEvent - " + event);
    GovGASTWD entity = new GovGASTWD();
    entity.setGovGASTWDId(event.getGovGASTWDId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UpdateGovGASTWDEvent
   */
  @EventHandler(payloadType = UpdateGovGASTWDEvent.class)
  public void handle(UpdateGovGASTWDEvent event) {
    LOGGER.info("handling UpdateGovGASTWDEvent - " + event);

    GovGASTWD entity = new GovGASTWD();
    entity.setGovGASTWDId(event.getGovGASTWDId());
    entity.setA(event.getA());
    entity.setAf1(event.getAf1());
    entity.setAf2(event.getAf2());
    entity.setB(event.getB());
    entity.setBf1(event.getBf1());
    entity.setBf2(event.getBf2());
    entity.setC(event.getC());
    entity.setCf2(event.getCf2());
    entity.setEcr(event.getEcr());
    entity.setEtd(event.getEtd());
    entity.setK3(event.getK3());
    entity.setK4(event.getK4());
    entity.setK5(event.getK5());
    entity.setK6(event.getK6());
    entity.setKd(event.getKd());
    entity.setKdroop(event.getKdroop());
    entity.setKf(event.getKf());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMwbase(event.getMwbase());
    entity.setT(event.getT());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setTc(event.getTc());
    entity.setTcd(event.getTcd());
    entity.setTd(event.getTd());
    entity.setTf(event.getTf());
    entity.setTmax(event.getTmax());
    entity.setTmin(event.getTmin());
    entity.setTr(event.getTr());
    entity.setTrate(event.getTrate());
    entity.setTt(event.getTt());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event DeleteGovGASTWDEvent
   */
  @EventHandler(payloadType = DeleteGovGASTWDEvent.class)
  public void handle(DeleteGovGASTWDEvent event) {
    LOGGER.info("handling DeleteGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovGASTWD entity = delete(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignAToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignAToGovGASTWDEvent.class)
  public void handle(AssignAToGovGASTWDEvent event) {
    LOGGER.info("handling AssignAToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignA(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignAFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignAFromGovGASTWDEvent.class)
  public void handle(UnAssignAFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignAFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignA(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignAf1ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignAf1ToGovGASTWDEvent.class)
  public void handle(AssignAf1ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignAf1ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignAf1(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignAf1FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignAf1FromGovGASTWDEvent.class)
  public void handle(UnAssignAf1FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignAf1FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignAf1(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignAf2ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignAf2ToGovGASTWDEvent.class)
  public void handle(AssignAf2ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignAf2ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignAf2(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignAf2FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignAf2FromGovGASTWDEvent.class)
  public void handle(UnAssignAf2FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignAf2FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignAf2(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignBToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignBToGovGASTWDEvent.class)
  public void handle(AssignBToGovGASTWDEvent event) {
    LOGGER.info("handling AssignBToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignB(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignBFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignBFromGovGASTWDEvent.class)
  public void handle(UnAssignBFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignBFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignB(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignBf1ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignBf1ToGovGASTWDEvent.class)
  public void handle(AssignBf1ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignBf1ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignBf1(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignBf1FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignBf1FromGovGASTWDEvent.class)
  public void handle(UnAssignBf1FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignBf1FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignBf1(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignBf2ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignBf2ToGovGASTWDEvent.class)
  public void handle(AssignBf2ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignBf2ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignBf2(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignBf2FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignBf2FromGovGASTWDEvent.class)
  public void handle(UnAssignBf2FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignBf2FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignBf2(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignCToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignCToGovGASTWDEvent.class)
  public void handle(AssignCToGovGASTWDEvent event) {
    LOGGER.info("handling AssignCToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignC(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignCFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignCFromGovGASTWDEvent.class)
  public void handle(UnAssignCFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignCFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignC(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignCf2ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignCf2ToGovGASTWDEvent.class)
  public void handle(AssignCf2ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignCf2ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignCf2(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignCf2FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignCf2FromGovGASTWDEvent.class)
  public void handle(UnAssignCf2FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignCf2FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignCf2(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignEcrToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignEcrToGovGASTWDEvent.class)
  public void handle(AssignEcrToGovGASTWDEvent event) {
    LOGGER.info("handling AssignEcrToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignEcr(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignEcrFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignEcrFromGovGASTWDEvent.class)
  public void handle(UnAssignEcrFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignEcrFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignEcr(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignEtdToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignEtdToGovGASTWDEvent.class)
  public void handle(AssignEtdToGovGASTWDEvent event) {
    LOGGER.info("handling AssignEtdToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignEtd(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignEtdFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignEtdFromGovGASTWDEvent.class)
  public void handle(UnAssignEtdFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignEtdFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignEtd(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignK3ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignK3ToGovGASTWDEvent.class)
  public void handle(AssignK3ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignK3ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignK3(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignK3FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignK3FromGovGASTWDEvent.class)
  public void handle(UnAssignK3FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignK3FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignK3(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignK4ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignK4ToGovGASTWDEvent.class)
  public void handle(AssignK4ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignK4ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignK4(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignK4FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignK4FromGovGASTWDEvent.class)
  public void handle(UnAssignK4FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignK4FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignK4(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignK5ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignK5ToGovGASTWDEvent.class)
  public void handle(AssignK5ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignK5ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignK5(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignK5FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignK5FromGovGASTWDEvent.class)
  public void handle(UnAssignK5FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignK5FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignK5(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignK6ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignK6ToGovGASTWDEvent.class)
  public void handle(AssignK6ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignK6ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignK6(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignK6FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignK6FromGovGASTWDEvent.class)
  public void handle(UnAssignK6FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignK6FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignK6(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignKdToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignKdToGovGASTWDEvent.class)
  public void handle(AssignKdToGovGASTWDEvent event) {
    LOGGER.info("handling AssignKdToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignKd(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignKdFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignKdFromGovGASTWDEvent.class)
  public void handle(UnAssignKdFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignKdFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignKd(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignKdroopToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignKdroopToGovGASTWDEvent.class)
  public void handle(AssignKdroopToGovGASTWDEvent event) {
    LOGGER.info("handling AssignKdroopToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignKdroop(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignKdroopFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignKdroopFromGovGASTWDEvent.class)
  public void handle(UnAssignKdroopFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignKdroopFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignKdroop(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignKfToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignKfToGovGASTWDEvent.class)
  public void handle(AssignKfToGovGASTWDEvent event) {
    LOGGER.info("handling AssignKfToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignKf(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignKfFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignKfFromGovGASTWDEvent.class)
  public void handle(UnAssignKfFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignKfFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignKf(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignKiToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignKiToGovGASTWDEvent.class)
  public void handle(AssignKiToGovGASTWDEvent event) {
    LOGGER.info("handling AssignKiToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignKi(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignKiFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignKiFromGovGASTWDEvent.class)
  public void handle(UnAssignKiFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignKiFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignKi(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignKpToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignKpToGovGASTWDEvent.class)
  public void handle(AssignKpToGovGASTWDEvent event) {
    LOGGER.info("handling AssignKpToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignKp(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignKpFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignKpFromGovGASTWDEvent.class)
  public void handle(UnAssignKpFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignKpFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignKp(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignMwbaseToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovGASTWDEvent.class)
  public void handle(AssignMwbaseToGovGASTWDEvent event) {
    LOGGER.info("handling AssignMwbaseToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignMwbase(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovGASTWDEvent.class)
  public void handle(UnAssignMwbaseFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignMwbase(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTToGovGASTWDEvent.class)
  public void handle(AssignTToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignT(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTFromGovGASTWDEvent.class)
  public void handle(UnAssignTFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignT(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignT3ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignT3ToGovGASTWDEvent.class)
  public void handle(AssignT3ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignT3ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignT3(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignT3FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignT3FromGovGASTWDEvent.class)
  public void handle(UnAssignT3FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignT3FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignT3(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignT4ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignT4ToGovGASTWDEvent.class)
  public void handle(AssignT4ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignT4ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignT4(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignT4FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignT4FromGovGASTWDEvent.class)
  public void handle(UnAssignT4FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignT4FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignT4(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignT5ToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignT5ToGovGASTWDEvent.class)
  public void handle(AssignT5ToGovGASTWDEvent event) {
    LOGGER.info("handling AssignT5ToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignT5(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignT5FromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignT5FromGovGASTWDEvent.class)
  public void handle(UnAssignT5FromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignT5FromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignT5(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTcToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTcToGovGASTWDEvent.class)
  public void handle(AssignTcToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTcToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTc(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTcFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTcFromGovGASTWDEvent.class)
  public void handle(UnAssignTcFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTcFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTc(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTcdToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTcdToGovGASTWDEvent.class)
  public void handle(AssignTcdToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTcdToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTcd(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTcdFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTcdFromGovGASTWDEvent.class)
  public void handle(UnAssignTcdFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTcdFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTcd(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTdToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTdToGovGASTWDEvent.class)
  public void handle(AssignTdToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTdToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTd(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTdFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTdFromGovGASTWDEvent.class)
  public void handle(UnAssignTdFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTdFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTd(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTfToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTfToGovGASTWDEvent.class)
  public void handle(AssignTfToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTfToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTf(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTfFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTfFromGovGASTWDEvent.class)
  public void handle(UnAssignTfFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTfFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTf(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTmaxToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTmaxToGovGASTWDEvent.class)
  public void handle(AssignTmaxToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTmaxToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTmax(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTmaxFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTmaxFromGovGASTWDEvent.class)
  public void handle(UnAssignTmaxFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTmaxFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTmax(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTminToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTminToGovGASTWDEvent.class)
  public void handle(AssignTminToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTminToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTmin(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTminFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTminFromGovGASTWDEvent.class)
  public void handle(UnAssignTminFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTminFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTmin(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTrToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTrToGovGASTWDEvent.class)
  public void handle(AssignTrToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTrToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTr(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTrFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTrFromGovGASTWDEvent.class)
  public void handle(UnAssignTrFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTrFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTr(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTrateToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTrateToGovGASTWDEvent.class)
  public void handle(AssignTrateToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTrateToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTrate(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTrateFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTrateFromGovGASTWDEvent.class)
  public void handle(UnAssignTrateFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTrateFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTrate(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event AssignTtToGovGASTWDEvent
   */
  @EventHandler(payloadType = AssignTtToGovGASTWDEvent.class)
  public void handle(AssignTtToGovGASTWDEvent event) {
    LOGGER.info("handling AssignTtToGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGASTWD entity = assignTt(event.getGovGASTWDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /*
   * @param	event UnAssignTtFromGovGASTWDEvent
   */
  @EventHandler(payloadType = UnAssignTtFromGovGASTWDEvent.class)
  public void handle(UnAssignTtFromGovGASTWDEvent event) {
    LOGGER.info("handling UnAssignTtFromGovGASTWDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGASTWD entity = unAssignTt(event.getGovGASTWDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGASTWD(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGASTWD(entity);
  }

  /**
   * Method to retrieve the GovGASTWD via an GovGASTWDPrimaryKey.
   *
   * @param id Long
   * @return GovGASTWD
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovGASTWD handle(FindGovGASTWDQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovGASTWDId());
  }

  /**
   * Method to retrieve a collection of all GovGASTWDs
   *
   * @param query FindAllGovGASTWDQuery
   * @return List<GovGASTWD>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovGASTWD> handle(FindAllGovGASTWDQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovGASTWD, but only if the id matches
   *
   * @param entity GovGASTWD
   */
  protected void emitFindGovGASTWD(GovGASTWD entity) {
    LOGGER.info("handling emitFindGovGASTWD");

    queryUpdateEmitter.emit(
        FindGovGASTWDQuery.class,
        query -> query.getFilter().getGovGASTWDId().equals(entity.getGovGASTWDId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovGASTWD
   *
   * @param entity GovGASTWD
   */
  protected void emitFindAllGovGASTWD(GovGASTWD entity) {
    LOGGER.info("handling emitFindAllGovGASTWD");

    queryUpdateEmitter.emit(FindAllGovGASTWDQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovGASTWDProjector.class.getName());
}
