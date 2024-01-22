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
 * Projector for GovSteamEU as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteamEU are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteamEUAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamEU")
@Component("govSteamEU-projector")
public class GovSteamEUProjector extends GovSteamEUEntityProjector {

  // core constructor
  public GovSteamEUProjector(
      GovSteamEURepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamEUEvent
   */
  @EventHandler(payloadType = CreateGovSteamEUEvent.class)
  public void handle(CreateGovSteamEUEvent event) {
    LOGGER.info("handling CreateGovSteamEUEvent - " + event);
    GovSteamEU entity = new GovSteamEU();
    entity.setGovSteamEUId(event.getGovSteamEUId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UpdateGovSteamEUEvent
   */
  @EventHandler(payloadType = UpdateGovSteamEUEvent.class)
  public void handle(UpdateGovSteamEUEvent event) {
    LOGGER.info("handling UpdateGovSteamEUEvent - " + event);

    GovSteamEU entity = new GovSteamEU();
    entity.setGovSteamEUId(event.getGovSteamEUId());
    entity.setChc(event.getChc());
    entity.setCho(event.getCho());
    entity.setCic(event.getCic());
    entity.setCio(event.getCio());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setHhpmax(event.getHhpmax());
    entity.setKe(event.getKe());
    entity.setKfcor(event.getKfcor());
    entity.setKhp(event.getKhp());
    entity.setKlp(event.getKlp());
    entity.setKwcor(event.getKwcor());
    entity.setMwbase(event.getMwbase());
    entity.setPmax(event.getPmax());
    entity.setPrhmax(event.getPrhmax());
    entity.setSimx(event.getSimx());
    entity.setTb(event.getTb());
    entity.setTdp(event.getTdp());
    entity.setTen(event.getTen());
    entity.setTf(event.getTf());
    entity.setTfp(event.getTfp());
    entity.setThp(event.getThp());
    entity.setTip(event.getTip());
    entity.setTlp(event.getTlp());
    entity.setTp(event.getTp());
    entity.setTrh(event.getTrh());
    entity.setTvhp(event.getTvhp());
    entity.setTvip(event.getTvip());
    entity.setTw(event.getTw());
    entity.setWfmax(event.getWfmax());
    entity.setWfmin(event.getWfmin());
    entity.setWmax1(event.getWmax1());
    entity.setWmax2(event.getWmax2());
    entity.setWwmax(event.getWwmax());
    entity.setWwmin(event.getWwmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event DeleteGovSteamEUEvent
   */
  @EventHandler(payloadType = DeleteGovSteamEUEvent.class)
  public void handle(DeleteGovSteamEUEvent event) {
    LOGGER.info("handling DeleteGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamEU entity = delete(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignChcToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignChcToGovSteamEUEvent.class)
  public void handle(AssignChcToGovSteamEUEvent event) {
    LOGGER.info("handling AssignChcToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignChc(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignChcFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignChcFromGovSteamEUEvent.class)
  public void handle(UnAssignChcFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignChcFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignChc(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignChoToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignChoToGovSteamEUEvent.class)
  public void handle(AssignChoToGovSteamEUEvent event) {
    LOGGER.info("handling AssignChoToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignCho(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignChoFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignChoFromGovSteamEUEvent.class)
  public void handle(UnAssignChoFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignChoFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignCho(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignCicToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignCicToGovSteamEUEvent.class)
  public void handle(AssignCicToGovSteamEUEvent event) {
    LOGGER.info("handling AssignCicToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignCic(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignCicFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignCicFromGovSteamEUEvent.class)
  public void handle(UnAssignCicFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignCicFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignCic(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignCioToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignCioToGovSteamEUEvent.class)
  public void handle(AssignCioToGovSteamEUEvent event) {
    LOGGER.info("handling AssignCioToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignCio(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignCioFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignCioFromGovSteamEUEvent.class)
  public void handle(UnAssignCioFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignCioFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignCio(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignDb1ToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignDb1ToGovSteamEUEvent.class)
  public void handle(AssignDb1ToGovSteamEUEvent event) {
    LOGGER.info("handling AssignDb1ToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignDb1(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignDb1FromGovSteamEUEvent.class)
  public void handle(UnAssignDb1FromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignDb1FromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignDb1(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignDb2ToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignDb2ToGovSteamEUEvent.class)
  public void handle(AssignDb2ToGovSteamEUEvent event) {
    LOGGER.info("handling AssignDb2ToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignDb2(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignDb2FromGovSteamEUEvent.class)
  public void handle(UnAssignDb2FromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignDb2FromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignDb2(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignHhpmaxToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignHhpmaxToGovSteamEUEvent.class)
  public void handle(AssignHhpmaxToGovSteamEUEvent event) {
    LOGGER.info("handling AssignHhpmaxToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignHhpmax(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignHhpmaxFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignHhpmaxFromGovSteamEUEvent.class)
  public void handle(UnAssignHhpmaxFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignHhpmaxFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignHhpmax(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignKeToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignKeToGovSteamEUEvent.class)
  public void handle(AssignKeToGovSteamEUEvent event) {
    LOGGER.info("handling AssignKeToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignKe(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignKeFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignKeFromGovSteamEUEvent.class)
  public void handle(UnAssignKeFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignKeFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignKe(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignKfcorToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignKfcorToGovSteamEUEvent.class)
  public void handle(AssignKfcorToGovSteamEUEvent event) {
    LOGGER.info("handling AssignKfcorToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignKfcor(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignKfcorFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignKfcorFromGovSteamEUEvent.class)
  public void handle(UnAssignKfcorFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignKfcorFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignKfcor(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignKhpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignKhpToGovSteamEUEvent.class)
  public void handle(AssignKhpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignKhpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignKhp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignKhpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignKhpFromGovSteamEUEvent.class)
  public void handle(UnAssignKhpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignKhpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignKhp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignKlpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignKlpToGovSteamEUEvent.class)
  public void handle(AssignKlpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignKlpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignKlp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignKlpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignKlpFromGovSteamEUEvent.class)
  public void handle(UnAssignKlpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignKlpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignKlp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignKwcorToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignKwcorToGovSteamEUEvent.class)
  public void handle(AssignKwcorToGovSteamEUEvent event) {
    LOGGER.info("handling AssignKwcorToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignKwcor(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignKwcorFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignKwcorFromGovSteamEUEvent.class)
  public void handle(UnAssignKwcorFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignKwcorFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignKwcor(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteamEUEvent.class)
  public void handle(AssignMwbaseToGovSteamEUEvent event) {
    LOGGER.info("handling AssignMwbaseToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignMwbase(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteamEUEvent.class)
  public void handle(UnAssignMwbaseFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignMwbase(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignPmaxToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignPmaxToGovSteamEUEvent.class)
  public void handle(AssignPmaxToGovSteamEUEvent event) {
    LOGGER.info("handling AssignPmaxToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignPmax(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovSteamEUEvent.class)
  public void handle(UnAssignPmaxFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignPmaxFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignPmax(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignPrhmaxToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignPrhmaxToGovSteamEUEvent.class)
  public void handle(AssignPrhmaxToGovSteamEUEvent event) {
    LOGGER.info("handling AssignPrhmaxToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignPrhmax(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignPrhmaxFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignPrhmaxFromGovSteamEUEvent.class)
  public void handle(UnAssignPrhmaxFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignPrhmaxFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignPrhmax(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignSimxToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignSimxToGovSteamEUEvent.class)
  public void handle(AssignSimxToGovSteamEUEvent event) {
    LOGGER.info("handling AssignSimxToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignSimx(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignSimxFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignSimxFromGovSteamEUEvent.class)
  public void handle(UnAssignSimxFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignSimxFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignSimx(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTbToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTbToGovSteamEUEvent.class)
  public void handle(AssignTbToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTbToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTb(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTbFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTbFromGovSteamEUEvent.class)
  public void handle(UnAssignTbFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTbFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTb(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTdpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTdpToGovSteamEUEvent.class)
  public void handle(AssignTdpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTdpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTdp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTdpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTdpFromGovSteamEUEvent.class)
  public void handle(UnAssignTdpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTdpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTdp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTenToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTenToGovSteamEUEvent.class)
  public void handle(AssignTenToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTenToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTen(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTenFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTenFromGovSteamEUEvent.class)
  public void handle(UnAssignTenFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTenFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTen(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTfToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTfToGovSteamEUEvent.class)
  public void handle(AssignTfToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTfToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTf(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTfFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTfFromGovSteamEUEvent.class)
  public void handle(UnAssignTfFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTfFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTf(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTfpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTfpToGovSteamEUEvent.class)
  public void handle(AssignTfpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTfpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTfp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTfpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTfpFromGovSteamEUEvent.class)
  public void handle(UnAssignTfpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTfpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTfp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignThpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignThpToGovSteamEUEvent.class)
  public void handle(AssignThpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignThpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignThp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignThpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignThpFromGovSteamEUEvent.class)
  public void handle(UnAssignThpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignThpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignThp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTipToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTipToGovSteamEUEvent.class)
  public void handle(AssignTipToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTipToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTip(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTipFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTipFromGovSteamEUEvent.class)
  public void handle(UnAssignTipFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTipFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTip(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTlpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTlpToGovSteamEUEvent.class)
  public void handle(AssignTlpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTlpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTlp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTlpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTlpFromGovSteamEUEvent.class)
  public void handle(UnAssignTlpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTlpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTlp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTpToGovSteamEUEvent.class)
  public void handle(AssignTpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTpFromGovSteamEUEvent.class)
  public void handle(UnAssignTpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTrhToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTrhToGovSteamEUEvent.class)
  public void handle(AssignTrhToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTrhToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTrh(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTrhFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTrhFromGovSteamEUEvent.class)
  public void handle(UnAssignTrhFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTrhFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTrh(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTvhpToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTvhpToGovSteamEUEvent.class)
  public void handle(AssignTvhpToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTvhpToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTvhp(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTvhpFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTvhpFromGovSteamEUEvent.class)
  public void handle(UnAssignTvhpFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTvhpFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTvhp(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTvipToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTvipToGovSteamEUEvent.class)
  public void handle(AssignTvipToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTvipToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTvip(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTvipFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTvipFromGovSteamEUEvent.class)
  public void handle(UnAssignTvipFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTvipFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTvip(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignTwToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignTwToGovSteamEUEvent.class)
  public void handle(AssignTwToGovSteamEUEvent event) {
    LOGGER.info("handling AssignTwToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignTw(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignTwFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignTwFromGovSteamEUEvent.class)
  public void handle(UnAssignTwFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignTwFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignTw(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignWfmaxToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignWfmaxToGovSteamEUEvent.class)
  public void handle(AssignWfmaxToGovSteamEUEvent event) {
    LOGGER.info("handling AssignWfmaxToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignWfmax(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignWfmaxFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignWfmaxFromGovSteamEUEvent.class)
  public void handle(UnAssignWfmaxFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignWfmaxFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignWfmax(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignWfminToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignWfminToGovSteamEUEvent.class)
  public void handle(AssignWfminToGovSteamEUEvent event) {
    LOGGER.info("handling AssignWfminToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignWfmin(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignWfminFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignWfminFromGovSteamEUEvent.class)
  public void handle(UnAssignWfminFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignWfminFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignWfmin(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignWmax1ToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignWmax1ToGovSteamEUEvent.class)
  public void handle(AssignWmax1ToGovSteamEUEvent event) {
    LOGGER.info("handling AssignWmax1ToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignWmax1(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignWmax1FromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignWmax1FromGovSteamEUEvent.class)
  public void handle(UnAssignWmax1FromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignWmax1FromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignWmax1(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignWmax2ToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignWmax2ToGovSteamEUEvent.class)
  public void handle(AssignWmax2ToGovSteamEUEvent event) {
    LOGGER.info("handling AssignWmax2ToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignWmax2(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignWmax2FromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignWmax2FromGovSteamEUEvent.class)
  public void handle(UnAssignWmax2FromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignWmax2FromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignWmax2(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignWwmaxToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignWwmaxToGovSteamEUEvent.class)
  public void handle(AssignWwmaxToGovSteamEUEvent event) {
    LOGGER.info("handling AssignWwmaxToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignWwmax(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignWwmaxFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignWwmaxFromGovSteamEUEvent.class)
  public void handle(UnAssignWwmaxFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignWwmaxFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignWwmax(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event AssignWwminToGovSteamEUEvent
   */
  @EventHandler(payloadType = AssignWwminToGovSteamEUEvent.class)
  public void handle(AssignWwminToGovSteamEUEvent event) {
    LOGGER.info("handling AssignWwminToGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamEU entity = assignWwmin(event.getGovSteamEUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /*
   * @param	event UnAssignWwminFromGovSteamEUEvent
   */
  @EventHandler(payloadType = UnAssignWwminFromGovSteamEUEvent.class)
  public void handle(UnAssignWwminFromGovSteamEUEvent event) {
    LOGGER.info("handling UnAssignWwminFromGovSteamEUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamEU entity = unAssignWwmin(event.getGovSteamEUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamEU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamEU(entity);
  }

  /**
   * Method to retrieve the GovSteamEU via an GovSteamEUPrimaryKey.
   *
   * @param id Long
   * @return GovSteamEU
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamEU handle(FindGovSteamEUQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamEUId());
  }

  /**
   * Method to retrieve a collection of all GovSteamEUs
   *
   * @param query FindAllGovSteamEUQuery
   * @return List<GovSteamEU>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamEU> handle(FindAllGovSteamEUQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamEU, but only if the id matches
   *
   * @param entity GovSteamEU
   */
  protected void emitFindGovSteamEU(GovSteamEU entity) {
    LOGGER.info("handling emitFindGovSteamEU");

    queryUpdateEmitter.emit(
        FindGovSteamEUQuery.class,
        query -> query.getFilter().getGovSteamEUId().equals(entity.getGovSteamEUId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamEU
   *
   * @param entity GovSteamEU
   */
  protected void emitFindAllGovSteamEU(GovSteamEU entity) {
    LOGGER.info("handling emitFindAllGovSteamEU");

    queryUpdateEmitter.emit(FindAllGovSteamEUQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamEUProjector.class.getName());
}
