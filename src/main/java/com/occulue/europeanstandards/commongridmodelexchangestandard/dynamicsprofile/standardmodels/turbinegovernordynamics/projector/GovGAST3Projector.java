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
 * Projector for GovGAST3 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovGAST3 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovGAST3Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govGAST3")
@Component("govGAST3-projector")
public class GovGAST3Projector extends GovGAST3EntityProjector {

  // core constructor
  public GovGAST3Projector(GovGAST3Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovGAST3Event
   */
  @EventHandler(payloadType = CreateGovGAST3Event.class)
  public void handle(CreateGovGAST3Event event) {
    LOGGER.info("handling CreateGovGAST3Event - " + event);
    GovGAST3 entity = new GovGAST3();
    entity.setGovGAST3Id(event.getGovGAST3Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UpdateGovGAST3Event
   */
  @EventHandler(payloadType = UpdateGovGAST3Event.class)
  public void handle(UpdateGovGAST3Event event) {
    LOGGER.info("handling UpdateGovGAST3Event - " + event);

    GovGAST3 entity = new GovGAST3();
    entity.setGovGAST3Id(event.getGovGAST3Id());
    entity.setBca(event.getBca());
    entity.setBp(event.getBp());
    entity.setDtc(event.getDtc());
    entity.setKa(event.getKa());
    entity.setKac(event.getKac());
    entity.setKca(event.getKca());
    entity.setKsi(event.getKsi());
    entity.setKy(event.getKy());
    entity.setMnef(event.getMnef());
    entity.setMxef(event.getMxef());
    entity.setRcmn(event.getRcmn());
    entity.setRcmx(event.getRcmx());
    entity.setTac(event.getTac());
    entity.setTc(event.getTc());
    entity.setTd(event.getTd());
    entity.setTfen(event.getTfen());
    entity.setTg(event.getTg());
    entity.setTsi(event.getTsi());
    entity.setTt(event.getTt());
    entity.setTtc(event.getTtc());
    entity.setTy(event.getTy());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event DeleteGovGAST3Event
   */
  @EventHandler(payloadType = DeleteGovGAST3Event.class)
  public void handle(DeleteGovGAST3Event event) {
    LOGGER.info("handling DeleteGovGAST3Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovGAST3 entity = delete(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignBcaToGovGAST3Event
   */
  @EventHandler(payloadType = AssignBcaToGovGAST3Event.class)
  public void handle(AssignBcaToGovGAST3Event event) {
    LOGGER.info("handling AssignBcaToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignBca(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignBcaFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignBcaFromGovGAST3Event.class)
  public void handle(UnAssignBcaFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignBcaFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignBca(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignBpToGovGAST3Event
   */
  @EventHandler(payloadType = AssignBpToGovGAST3Event.class)
  public void handle(AssignBpToGovGAST3Event event) {
    LOGGER.info("handling AssignBpToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignBp(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignBpFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignBpFromGovGAST3Event.class)
  public void handle(UnAssignBpFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignBpFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignBp(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignDtcToGovGAST3Event
   */
  @EventHandler(payloadType = AssignDtcToGovGAST3Event.class)
  public void handle(AssignDtcToGovGAST3Event event) {
    LOGGER.info("handling AssignDtcToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignDtc(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignDtcFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignDtcFromGovGAST3Event.class)
  public void handle(UnAssignDtcFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignDtcFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignDtc(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignKaToGovGAST3Event
   */
  @EventHandler(payloadType = AssignKaToGovGAST3Event.class)
  public void handle(AssignKaToGovGAST3Event event) {
    LOGGER.info("handling AssignKaToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignKa(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignKaFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignKaFromGovGAST3Event.class)
  public void handle(UnAssignKaFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignKaFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignKa(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignKacToGovGAST3Event
   */
  @EventHandler(payloadType = AssignKacToGovGAST3Event.class)
  public void handle(AssignKacToGovGAST3Event event) {
    LOGGER.info("handling AssignKacToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignKac(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignKacFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignKacFromGovGAST3Event.class)
  public void handle(UnAssignKacFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignKacFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignKac(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignKcaToGovGAST3Event
   */
  @EventHandler(payloadType = AssignKcaToGovGAST3Event.class)
  public void handle(AssignKcaToGovGAST3Event event) {
    LOGGER.info("handling AssignKcaToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignKca(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignKcaFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignKcaFromGovGAST3Event.class)
  public void handle(UnAssignKcaFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignKcaFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignKca(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignKsiToGovGAST3Event
   */
  @EventHandler(payloadType = AssignKsiToGovGAST3Event.class)
  public void handle(AssignKsiToGovGAST3Event event) {
    LOGGER.info("handling AssignKsiToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignKsi(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignKsiFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignKsiFromGovGAST3Event.class)
  public void handle(UnAssignKsiFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignKsiFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignKsi(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignKyToGovGAST3Event
   */
  @EventHandler(payloadType = AssignKyToGovGAST3Event.class)
  public void handle(AssignKyToGovGAST3Event event) {
    LOGGER.info("handling AssignKyToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignKy(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignKyFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignKyFromGovGAST3Event.class)
  public void handle(UnAssignKyFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignKyFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignKy(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignMnefToGovGAST3Event
   */
  @EventHandler(payloadType = AssignMnefToGovGAST3Event.class)
  public void handle(AssignMnefToGovGAST3Event event) {
    LOGGER.info("handling AssignMnefToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignMnef(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignMnefFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignMnefFromGovGAST3Event.class)
  public void handle(UnAssignMnefFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignMnefFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignMnef(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignMxefToGovGAST3Event
   */
  @EventHandler(payloadType = AssignMxefToGovGAST3Event.class)
  public void handle(AssignMxefToGovGAST3Event event) {
    LOGGER.info("handling AssignMxefToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignMxef(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignMxefFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignMxefFromGovGAST3Event.class)
  public void handle(UnAssignMxefFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignMxefFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignMxef(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignRcmnToGovGAST3Event
   */
  @EventHandler(payloadType = AssignRcmnToGovGAST3Event.class)
  public void handle(AssignRcmnToGovGAST3Event event) {
    LOGGER.info("handling AssignRcmnToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignRcmn(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignRcmnFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignRcmnFromGovGAST3Event.class)
  public void handle(UnAssignRcmnFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignRcmnFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignRcmn(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignRcmxToGovGAST3Event
   */
  @EventHandler(payloadType = AssignRcmxToGovGAST3Event.class)
  public void handle(AssignRcmxToGovGAST3Event event) {
    LOGGER.info("handling AssignRcmxToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignRcmx(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignRcmxFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignRcmxFromGovGAST3Event.class)
  public void handle(UnAssignRcmxFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignRcmxFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignRcmx(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTacToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTacToGovGAST3Event.class)
  public void handle(AssignTacToGovGAST3Event event) {
    LOGGER.info("handling AssignTacToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTac(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTacFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTacFromGovGAST3Event.class)
  public void handle(UnAssignTacFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTacFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTac(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTcToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTcToGovGAST3Event.class)
  public void handle(AssignTcToGovGAST3Event event) {
    LOGGER.info("handling AssignTcToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTc(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTcFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovGAST3Event.class)
  public void handle(UnAssignTcFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTcFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTc(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTdToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTdToGovGAST3Event.class)
  public void handle(AssignTdToGovGAST3Event event) {
    LOGGER.info("handling AssignTdToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTd(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTdFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTdFromGovGAST3Event.class)
  public void handle(UnAssignTdFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTdFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTd(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTfenToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTfenToGovGAST3Event.class)
  public void handle(AssignTfenToGovGAST3Event event) {
    LOGGER.info("handling AssignTfenToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTfen(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTfenFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTfenFromGovGAST3Event.class)
  public void handle(UnAssignTfenFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTfenFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTfen(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTgToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTgToGovGAST3Event.class)
  public void handle(AssignTgToGovGAST3Event event) {
    LOGGER.info("handling AssignTgToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTg(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTgFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTgFromGovGAST3Event.class)
  public void handle(UnAssignTgFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTgFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTg(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTsiToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTsiToGovGAST3Event.class)
  public void handle(AssignTsiToGovGAST3Event event) {
    LOGGER.info("handling AssignTsiToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTsi(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTsiFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTsiFromGovGAST3Event.class)
  public void handle(UnAssignTsiFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTsiFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTsi(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTtToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTtToGovGAST3Event.class)
  public void handle(AssignTtToGovGAST3Event event) {
    LOGGER.info("handling AssignTtToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTt(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTtFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTtFromGovGAST3Event.class)
  public void handle(UnAssignTtFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTtFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTt(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTtcToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTtcToGovGAST3Event.class)
  public void handle(AssignTtcToGovGAST3Event event) {
    LOGGER.info("handling AssignTtcToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTtc(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTtcFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTtcFromGovGAST3Event.class)
  public void handle(UnAssignTtcFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTtcFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTtc(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event AssignTyToGovGAST3Event
   */
  @EventHandler(payloadType = AssignTyToGovGAST3Event.class)
  public void handle(AssignTyToGovGAST3Event event) {
    LOGGER.info("handling AssignTyToGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST3 entity = assignTy(event.getGovGAST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /*
   * @param	event UnAssignTyFromGovGAST3Event
   */
  @EventHandler(payloadType = UnAssignTyFromGovGAST3Event.class)
  public void handle(UnAssignTyFromGovGAST3Event event) {
    LOGGER.info("handling UnAssignTyFromGovGAST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST3 entity = unAssignTy(event.getGovGAST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST3(entity);
  }

  /**
   * Method to retrieve the GovGAST3 via an GovGAST3PrimaryKey.
   *
   * @param id Long
   * @return GovGAST3
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovGAST3 handle(FindGovGAST3Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovGAST3Id());
  }

  /**
   * Method to retrieve a collection of all GovGAST3s
   *
   * @param query FindAllGovGAST3Query
   * @return List<GovGAST3>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovGAST3> handle(FindAllGovGAST3Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovGAST3, but only if the id matches
   *
   * @param entity GovGAST3
   */
  protected void emitFindGovGAST3(GovGAST3 entity) {
    LOGGER.info("handling emitFindGovGAST3");

    queryUpdateEmitter.emit(
        FindGovGAST3Query.class,
        query -> query.getFilter().getGovGAST3Id().equals(entity.getGovGAST3Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovGAST3
   *
   * @param entity GovGAST3
   */
  protected void emitFindAllGovGAST3(GovGAST3 entity) {
    LOGGER.info("handling emitFindAllGovGAST3");

    queryUpdateEmitter.emit(FindAllGovGAST3Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovGAST3Projector.class.getName());
}
