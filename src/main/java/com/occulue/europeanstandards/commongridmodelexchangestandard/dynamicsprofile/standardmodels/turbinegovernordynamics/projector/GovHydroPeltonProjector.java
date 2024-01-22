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
 * Projector for GovHydroPelton as outlined for the CQRS pattern. All event handling and query
 * handling related to GovHydroPelton are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovHydroPeltonAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroPelton")
@Component("govHydroPelton-projector")
public class GovHydroPeltonProjector extends GovHydroPeltonEntityProjector {

  // core constructor
  public GovHydroPeltonProjector(
      GovHydroPeltonRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroPeltonEvent
   */
  @EventHandler(payloadType = CreateGovHydroPeltonEvent.class)
  public void handle(CreateGovHydroPeltonEvent event) {
    LOGGER.info("handling CreateGovHydroPeltonEvent - " + event);
    GovHydroPelton entity = new GovHydroPelton();
    entity.setGovHydroPeltonId(event.getGovHydroPeltonId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UpdateGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UpdateGovHydroPeltonEvent.class)
  public void handle(UpdateGovHydroPeltonEvent event) {
    LOGGER.info("handling UpdateGovHydroPeltonEvent - " + event);

    GovHydroPelton entity = new GovHydroPelton();
    entity.setGovHydroPeltonId(event.getGovHydroPeltonId());
    entity.setAv0(event.getAv0());
    entity.setAv1(event.getAv1());
    entity.setBp(event.getBp());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setH1(event.getH1());
    entity.setH2(event.getH2());
    entity.setHn(event.getHn());
    entity.setKc(event.getKc());
    entity.setKg(event.getKg());
    entity.setQc0(event.getQc0());
    entity.setQn(event.getQn());
    entity.setSimplifiedPelton(event.getSimplifiedPelton());
    entity.setStaticCompensating(event.getStaticCompensating());
    entity.setTa(event.getTa());
    entity.setTs(event.getTs());
    entity.setTv(event.getTv());
    entity.setTwnc(event.getTwnc());
    entity.setTwng(event.getTwng());
    entity.setTx(event.getTx());
    entity.setVa(event.getVa());
    entity.setValvmax(event.getValvmax());
    entity.setValvmin(event.getValvmin());
    entity.setVav(event.getVav());
    entity.setVc(event.getVc());
    entity.setVcv(event.getVcv());
    entity.setWaterTunnelSurgeChamberSimulation(event.getWaterTunnelSurgeChamberSimulation());
    entity.setZsfc(event.getZsfc());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event DeleteGovHydroPeltonEvent
   */
  @EventHandler(payloadType = DeleteGovHydroPeltonEvent.class)
  public void handle(DeleteGovHydroPeltonEvent event) {
    LOGGER.info("handling DeleteGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroPelton entity = delete(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignAv0ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignAv0ToGovHydroPeltonEvent.class)
  public void handle(AssignAv0ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignAv0ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignAv0(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignAv0FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignAv0FromGovHydroPeltonEvent.class)
  public void handle(UnAssignAv0FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignAv0FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignAv0(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignAv1ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignAv1ToGovHydroPeltonEvent.class)
  public void handle(AssignAv1ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignAv1ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignAv1(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignAv1FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignAv1FromGovHydroPeltonEvent.class)
  public void handle(UnAssignAv1FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignAv1FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignAv1(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignBpToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignBpToGovHydroPeltonEvent.class)
  public void handle(AssignBpToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignBpToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignBp(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignBpFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignBpFromGovHydroPeltonEvent.class)
  public void handle(UnAssignBpFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignBpFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignBp(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignDb1ToGovHydroPeltonEvent.class)
  public void handle(AssignDb1ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignDb1ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignDb1(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydroPeltonEvent.class)
  public void handle(UnAssignDb1FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignDb1FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignDb1(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignDb2ToGovHydroPeltonEvent.class)
  public void handle(AssignDb2ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignDb2ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignDb2(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydroPeltonEvent.class)
  public void handle(UnAssignDb2FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignDb2FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignDb2(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignH1ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignH1ToGovHydroPeltonEvent.class)
  public void handle(AssignH1ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignH1ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignH1(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignH1FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignH1FromGovHydroPeltonEvent.class)
  public void handle(UnAssignH1FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignH1FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignH1(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignH2ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignH2ToGovHydroPeltonEvent.class)
  public void handle(AssignH2ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignH2ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignH2(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignH2FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignH2FromGovHydroPeltonEvent.class)
  public void handle(UnAssignH2FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignH2FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignH2(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignHnToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignHnToGovHydroPeltonEvent.class)
  public void handle(AssignHnToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignHnToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignHn(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignHnFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignHnFromGovHydroPeltonEvent.class)
  public void handle(UnAssignHnFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignHnFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignHn(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignKcToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignKcToGovHydroPeltonEvent.class)
  public void handle(AssignKcToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignKcToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignKc(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignKcFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignKcFromGovHydroPeltonEvent.class)
  public void handle(UnAssignKcFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignKcFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignKc(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignKgToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignKgToGovHydroPeltonEvent.class)
  public void handle(AssignKgToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignKgToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignKg(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignKgFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignKgFromGovHydroPeltonEvent.class)
  public void handle(UnAssignKgFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignKgFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignKg(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignQc0ToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignQc0ToGovHydroPeltonEvent.class)
  public void handle(AssignQc0ToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignQc0ToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignQc0(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignQc0FromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignQc0FromGovHydroPeltonEvent.class)
  public void handle(UnAssignQc0FromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignQc0FromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignQc0(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignQnToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignQnToGovHydroPeltonEvent.class)
  public void handle(AssignQnToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignQnToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignQn(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignQnFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignQnFromGovHydroPeltonEvent.class)
  public void handle(UnAssignQnFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignQnFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignQn(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignSimplifiedPeltonToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignSimplifiedPeltonToGovHydroPeltonEvent.class)
  public void handle(AssignSimplifiedPeltonToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignSimplifiedPeltonToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity =
        assignSimplifiedPelton(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignSimplifiedPeltonFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignSimplifiedPeltonFromGovHydroPeltonEvent.class)
  public void handle(UnAssignSimplifiedPeltonFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignSimplifiedPeltonFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignSimplifiedPelton(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignStaticCompensatingToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignStaticCompensatingToGovHydroPeltonEvent.class)
  public void handle(AssignStaticCompensatingToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignStaticCompensatingToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity =
        assignStaticCompensating(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignStaticCompensatingFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignStaticCompensatingFromGovHydroPeltonEvent.class)
  public void handle(UnAssignStaticCompensatingFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignStaticCompensatingFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignStaticCompensating(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignTaToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignTaToGovHydroPeltonEvent.class)
  public void handle(AssignTaToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignTaToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignTa(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignTaFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignTaFromGovHydroPeltonEvent.class)
  public void handle(UnAssignTaFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignTaFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignTa(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignTsToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignTsToGovHydroPeltonEvent.class)
  public void handle(AssignTsToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignTsToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignTs(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignTsFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignTsFromGovHydroPeltonEvent.class)
  public void handle(UnAssignTsFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignTsFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignTs(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignTvToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignTvToGovHydroPeltonEvent.class)
  public void handle(AssignTvToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignTvToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignTv(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignTvFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignTvFromGovHydroPeltonEvent.class)
  public void handle(UnAssignTvFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignTvFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignTv(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignTwncToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignTwncToGovHydroPeltonEvent.class)
  public void handle(AssignTwncToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignTwncToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignTwnc(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignTwncFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignTwncFromGovHydroPeltonEvent.class)
  public void handle(UnAssignTwncFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignTwncFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignTwnc(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignTwngToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignTwngToGovHydroPeltonEvent.class)
  public void handle(AssignTwngToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignTwngToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignTwng(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignTwngFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignTwngFromGovHydroPeltonEvent.class)
  public void handle(UnAssignTwngFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignTwngFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignTwng(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignTxToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignTxToGovHydroPeltonEvent.class)
  public void handle(AssignTxToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignTxToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignTx(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignTxFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignTxFromGovHydroPeltonEvent.class)
  public void handle(UnAssignTxFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignTxFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignTx(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignVaToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignVaToGovHydroPeltonEvent.class)
  public void handle(AssignVaToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignVaToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignVa(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignVaFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignVaFromGovHydroPeltonEvent.class)
  public void handle(UnAssignVaFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignVaFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignVa(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignValvmaxToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignValvmaxToGovHydroPeltonEvent.class)
  public void handle(AssignValvmaxToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignValvmaxToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignValvmax(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignValvmaxFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignValvmaxFromGovHydroPeltonEvent.class)
  public void handle(UnAssignValvmaxFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignValvmaxFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignValvmax(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignValvminToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignValvminToGovHydroPeltonEvent.class)
  public void handle(AssignValvminToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignValvminToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignValvmin(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignValvminFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignValvminFromGovHydroPeltonEvent.class)
  public void handle(UnAssignValvminFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignValvminFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignValvmin(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignVavToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignVavToGovHydroPeltonEvent.class)
  public void handle(AssignVavToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignVavToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignVav(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignVavFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignVavFromGovHydroPeltonEvent.class)
  public void handle(UnAssignVavFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignVavFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignVav(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignVcToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignVcToGovHydroPeltonEvent.class)
  public void handle(AssignVcToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignVcToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignVc(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignVcFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignVcFromGovHydroPeltonEvent.class)
  public void handle(UnAssignVcFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignVcFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignVc(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignVcvToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignVcvToGovHydroPeltonEvent.class)
  public void handle(AssignVcvToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignVcvToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignVcv(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignVcvFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignVcvFromGovHydroPeltonEvent.class)
  public void handle(UnAssignVcvFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignVcvFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignVcv(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent.class)
  public void handle(AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity =
        assignWaterTunnelSurgeChamberSimulation(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent
   */
  @EventHandler(
      payloadType = UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent.class)
  public void handle(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent event) {
    LOGGER.info(
        "handling UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignWaterTunnelSurgeChamberSimulation(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event AssignZsfcToGovHydroPeltonEvent
   */
  @EventHandler(payloadType = AssignZsfcToGovHydroPeltonEvent.class)
  public void handle(AssignZsfcToGovHydroPeltonEvent event) {
    LOGGER.info("handling AssignZsfcToGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPelton entity = assignZsfc(event.getGovHydroPeltonId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /*
   * @param	event UnAssignZsfcFromGovHydroPeltonEvent
   */
  @EventHandler(payloadType = UnAssignZsfcFromGovHydroPeltonEvent.class)
  public void handle(UnAssignZsfcFromGovHydroPeltonEvent event) {
    LOGGER.info("handling UnAssignZsfcFromGovHydroPeltonEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPelton entity = unAssignZsfc(event.getGovHydroPeltonId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPelton(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPelton(entity);
  }

  /**
   * Method to retrieve the GovHydroPelton via an GovHydroPeltonPrimaryKey.
   *
   * @param id Long
   * @return GovHydroPelton
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroPelton handle(FindGovHydroPeltonQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroPeltonId());
  }

  /**
   * Method to retrieve a collection of all GovHydroPeltons
   *
   * @param query FindAllGovHydroPeltonQuery
   * @return List<GovHydroPelton>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroPelton> handle(FindAllGovHydroPeltonQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroPelton, but only if the id matches
   *
   * @param entity GovHydroPelton
   */
  protected void emitFindGovHydroPelton(GovHydroPelton entity) {
    LOGGER.info("handling emitFindGovHydroPelton");

    queryUpdateEmitter.emit(
        FindGovHydroPeltonQuery.class,
        query -> query.getFilter().getGovHydroPeltonId().equals(entity.getGovHydroPeltonId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroPelton
   *
   * @param entity GovHydroPelton
   */
  protected void emitFindAllGovHydroPelton(GovHydroPelton entity) {
    LOGGER.info("handling emitFindAllGovHydroPelton");

    queryUpdateEmitter.emit(FindAllGovHydroPeltonQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroPeltonProjector.class.getName());
}
