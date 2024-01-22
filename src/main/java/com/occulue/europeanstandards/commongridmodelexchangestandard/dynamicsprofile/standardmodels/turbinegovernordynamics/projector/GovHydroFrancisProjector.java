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
 * Projector for GovHydroFrancis as outlined for the CQRS pattern. All event handling and query
 * handling related to GovHydroFrancis are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovHydroFrancisAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroFrancis")
@Component("govHydroFrancis-projector")
public class GovHydroFrancisProjector extends GovHydroFrancisEntityProjector {

  // core constructor
  public GovHydroFrancisProjector(
      GovHydroFrancisRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroFrancisEvent
   */
  @EventHandler(payloadType = CreateGovHydroFrancisEvent.class)
  public void handle(CreateGovHydroFrancisEvent event) {
    LOGGER.info("handling CreateGovHydroFrancisEvent - " + event);
    GovHydroFrancis entity = new GovHydroFrancis();
    entity.setGovHydroFrancisId(event.getGovHydroFrancisId());
    entity.setGovernorControl(event.getGovernorControl());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UpdateGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UpdateGovHydroFrancisEvent.class)
  public void handle(UpdateGovHydroFrancisEvent event) {
    LOGGER.info("handling UpdateGovHydroFrancisEvent - " + event);

    GovHydroFrancis entity = new GovHydroFrancis();
    entity.setGovHydroFrancisId(event.getGovHydroFrancisId());
    entity.setAm(event.getAm());
    entity.setAv0(event.getAv0());
    entity.setAv1(event.getAv1());
    entity.setBp(event.getBp());
    entity.setDb1(event.getDb1());
    entity.setEtamax(event.getEtamax());
    entity.setGovernorControl(event.getGovernorControl());
    entity.setH1(event.getH1());
    entity.setH2(event.getH2());
    entity.setHn(event.getHn());
    entity.setKc(event.getKc());
    entity.setKg(event.getKg());
    entity.setKt(event.getKt());
    entity.setQc0(event.getQc0());
    entity.setQn(event.getQn());
    entity.setTa(event.getTa());
    entity.setTd(event.getTd());
    entity.setTs(event.getTs());
    entity.setTwnc(event.getTwnc());
    entity.setTwng(event.getTwng());
    entity.setTx(event.getTx());
    entity.setVa(event.getVa());
    entity.setValvmax(event.getValvmax());
    entity.setValvmin(event.getValvmin());
    entity.setVc(event.getVc());
    entity.setWaterTunnelSurgeChamberSimulation(event.getWaterTunnelSurgeChamberSimulation());
    entity.setZsfc(event.getZsfc());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event DeleteGovHydroFrancisEvent
   */
  @EventHandler(payloadType = DeleteGovHydroFrancisEvent.class)
  public void handle(DeleteGovHydroFrancisEvent event) {
    LOGGER.info("handling DeleteGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroFrancis entity = delete(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignAmToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignAmToGovHydroFrancisEvent.class)
  public void handle(AssignAmToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignAmToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignAm(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignAmFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignAmFromGovHydroFrancisEvent.class)
  public void handle(UnAssignAmFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignAmFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignAm(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignAv0ToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignAv0ToGovHydroFrancisEvent.class)
  public void handle(AssignAv0ToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignAv0ToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignAv0(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignAv0FromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignAv0FromGovHydroFrancisEvent.class)
  public void handle(UnAssignAv0FromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignAv0FromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignAv0(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignAv1ToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignAv1ToGovHydroFrancisEvent.class)
  public void handle(AssignAv1ToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignAv1ToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignAv1(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignAv1FromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignAv1FromGovHydroFrancisEvent.class)
  public void handle(UnAssignAv1FromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignAv1FromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignAv1(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignBpToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignBpToGovHydroFrancisEvent.class)
  public void handle(AssignBpToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignBpToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignBp(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignBpFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignBpFromGovHydroFrancisEvent.class)
  public void handle(UnAssignBpFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignBpFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignBp(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignDb1ToGovHydroFrancisEvent.class)
  public void handle(AssignDb1ToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignDb1ToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignDb1(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydroFrancisEvent.class)
  public void handle(UnAssignDb1FromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignDb1FromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignDb1(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignEtamaxToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignEtamaxToGovHydroFrancisEvent.class)
  public void handle(AssignEtamaxToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignEtamaxToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignEtamax(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignEtamaxFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignEtamaxFromGovHydroFrancisEvent.class)
  public void handle(UnAssignEtamaxFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignEtamaxFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignEtamax(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignH1ToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignH1ToGovHydroFrancisEvent.class)
  public void handle(AssignH1ToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignH1ToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignH1(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignH1FromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignH1FromGovHydroFrancisEvent.class)
  public void handle(UnAssignH1FromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignH1FromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignH1(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignH2ToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignH2ToGovHydroFrancisEvent.class)
  public void handle(AssignH2ToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignH2ToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignH2(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignH2FromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignH2FromGovHydroFrancisEvent.class)
  public void handle(UnAssignH2FromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignH2FromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignH2(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignHnToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignHnToGovHydroFrancisEvent.class)
  public void handle(AssignHnToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignHnToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignHn(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignHnFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignHnFromGovHydroFrancisEvent.class)
  public void handle(UnAssignHnFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignHnFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignHn(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignKcToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignKcToGovHydroFrancisEvent.class)
  public void handle(AssignKcToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignKcToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignKc(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignKcFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignKcFromGovHydroFrancisEvent.class)
  public void handle(UnAssignKcFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignKcFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignKc(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignKgToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignKgToGovHydroFrancisEvent.class)
  public void handle(AssignKgToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignKgToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignKg(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignKgFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignKgFromGovHydroFrancisEvent.class)
  public void handle(UnAssignKgFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignKgFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignKg(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignKtToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignKtToGovHydroFrancisEvent.class)
  public void handle(AssignKtToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignKtToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignKt(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignKtFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignKtFromGovHydroFrancisEvent.class)
  public void handle(UnAssignKtFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignKtFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignKt(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignQc0ToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignQc0ToGovHydroFrancisEvent.class)
  public void handle(AssignQc0ToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignQc0ToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignQc0(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignQc0FromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignQc0FromGovHydroFrancisEvent.class)
  public void handle(UnAssignQc0FromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignQc0FromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignQc0(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignQnToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignQnToGovHydroFrancisEvent.class)
  public void handle(AssignQnToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignQnToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignQn(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignQnFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignQnFromGovHydroFrancisEvent.class)
  public void handle(UnAssignQnFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignQnFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignQn(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignTaToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignTaToGovHydroFrancisEvent.class)
  public void handle(AssignTaToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignTaToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignTa(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignTaFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignTaFromGovHydroFrancisEvent.class)
  public void handle(UnAssignTaFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignTaFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignTa(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignTdToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignTdToGovHydroFrancisEvent.class)
  public void handle(AssignTdToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignTdToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignTd(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignTdFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignTdFromGovHydroFrancisEvent.class)
  public void handle(UnAssignTdFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignTdFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignTd(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignTsToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignTsToGovHydroFrancisEvent.class)
  public void handle(AssignTsToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignTsToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignTs(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignTsFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignTsFromGovHydroFrancisEvent.class)
  public void handle(UnAssignTsFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignTsFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignTs(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignTwncToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignTwncToGovHydroFrancisEvent.class)
  public void handle(AssignTwncToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignTwncToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignTwnc(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignTwncFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignTwncFromGovHydroFrancisEvent.class)
  public void handle(UnAssignTwncFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignTwncFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignTwnc(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignTwngToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignTwngToGovHydroFrancisEvent.class)
  public void handle(AssignTwngToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignTwngToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignTwng(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignTwngFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignTwngFromGovHydroFrancisEvent.class)
  public void handle(UnAssignTwngFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignTwngFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignTwng(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignTxToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignTxToGovHydroFrancisEvent.class)
  public void handle(AssignTxToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignTxToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignTx(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignTxFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignTxFromGovHydroFrancisEvent.class)
  public void handle(UnAssignTxFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignTxFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignTx(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignVaToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignVaToGovHydroFrancisEvent.class)
  public void handle(AssignVaToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignVaToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignVa(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignVaFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignVaFromGovHydroFrancisEvent.class)
  public void handle(UnAssignVaFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignVaFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignVa(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignValvmaxToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignValvmaxToGovHydroFrancisEvent.class)
  public void handle(AssignValvmaxToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignValvmaxToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignValvmax(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignValvmaxFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignValvmaxFromGovHydroFrancisEvent.class)
  public void handle(UnAssignValvmaxFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignValvmaxFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignValvmax(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignValvminToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignValvminToGovHydroFrancisEvent.class)
  public void handle(AssignValvminToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignValvminToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignValvmin(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignValvminFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignValvminFromGovHydroFrancisEvent.class)
  public void handle(UnAssignValvminFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignValvminFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignValvmin(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignVcToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignVcToGovHydroFrancisEvent.class)
  public void handle(AssignVcToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignVcToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignVc(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignVcFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignVcFromGovHydroFrancisEvent.class)
  public void handle(UnAssignVcFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignVcFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignVc(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent.class)
  public void handle(AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent event) {
    LOGGER.info(
        "handling AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity =
        assignWaterTunnelSurgeChamberSimulation(
            event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent
   */
  @EventHandler(
      payloadType = UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent.class)
  public void handle(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent event) {
    LOGGER.info(
        "handling UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity =
        unAssignWaterTunnelSurgeChamberSimulation(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event AssignZsfcToGovHydroFrancisEvent
   */
  @EventHandler(payloadType = AssignZsfcToGovHydroFrancisEvent.class)
  public void handle(AssignZsfcToGovHydroFrancisEvent event) {
    LOGGER.info("handling AssignZsfcToGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroFrancis entity = assignZsfc(event.getGovHydroFrancisId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /*
   * @param	event UnAssignZsfcFromGovHydroFrancisEvent
   */
  @EventHandler(payloadType = UnAssignZsfcFromGovHydroFrancisEvent.class)
  public void handle(UnAssignZsfcFromGovHydroFrancisEvent event) {
    LOGGER.info("handling UnAssignZsfcFromGovHydroFrancisEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroFrancis entity = unAssignZsfc(event.getGovHydroFrancisId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroFrancis(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroFrancis(entity);
  }

  /**
   * Method to retrieve the GovHydroFrancis via an GovHydroFrancisPrimaryKey.
   *
   * @param id Long
   * @return GovHydroFrancis
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroFrancis handle(FindGovHydroFrancisQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroFrancisId());
  }

  /**
   * Method to retrieve a collection of all GovHydroFranciss
   *
   * @param query FindAllGovHydroFrancisQuery
   * @return List<GovHydroFrancis>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroFrancis> handle(FindAllGovHydroFrancisQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroFrancis, but only if the id matches
   *
   * @param entity GovHydroFrancis
   */
  protected void emitFindGovHydroFrancis(GovHydroFrancis entity) {
    LOGGER.info("handling emitFindGovHydroFrancis");

    queryUpdateEmitter.emit(
        FindGovHydroFrancisQuery.class,
        query -> query.getFilter().getGovHydroFrancisId().equals(entity.getGovHydroFrancisId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroFrancis
   *
   * @param entity GovHydroFrancis
   */
  protected void emitFindAllGovHydroFrancis(GovHydroFrancis entity) {
    LOGGER.info("handling emitFindAllGovHydroFrancis");

    queryUpdateEmitter.emit(FindAllGovHydroFrancisQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroFrancisProjector.class.getName());
}
