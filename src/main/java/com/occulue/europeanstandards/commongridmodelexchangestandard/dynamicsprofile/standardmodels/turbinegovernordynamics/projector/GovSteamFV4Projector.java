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
 * Projector for GovSteamFV4 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteamFV4 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteamFV4Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamFV4")
@Component("govSteamFV4-projector")
public class GovSteamFV4Projector extends GovSteamFV4EntityProjector {

  // core constructor
  public GovSteamFV4Projector(
      GovSteamFV4Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamFV4Event
   */
  @EventHandler(payloadType = CreateGovSteamFV4Event.class)
  public void handle(CreateGovSteamFV4Event event) {
    LOGGER.info("handling CreateGovSteamFV4Event - " + event);
    GovSteamFV4 entity = new GovSteamFV4();
    entity.setGovSteamFV4Id(event.getGovSteamFV4Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UpdateGovSteamFV4Event
   */
  @EventHandler(payloadType = UpdateGovSteamFV4Event.class)
  public void handle(UpdateGovSteamFV4Event event) {
    LOGGER.info("handling UpdateGovSteamFV4Event - " + event);

    GovSteamFV4 entity = new GovSteamFV4();
    entity.setGovSteamFV4Id(event.getGovSteamFV4Id());
    entity.setCpsmn(event.getCpsmn());
    entity.setCpsmx(event.getCpsmx());
    entity.setCrmn(event.getCrmn());
    entity.setCrmx(event.getCrmx());
    entity.setKdc(event.getKdc());
    entity.setKf1(event.getKf1());
    entity.setKf3(event.getKf3());
    entity.setKhp(event.getKhp());
    entity.setKic(event.getKic());
    entity.setKip(event.getKip());
    entity.setKit(event.getKit());
    entity.setKmp1(event.getKmp1());
    entity.setKmp2(event.getKmp2());
    entity.setKpc(event.getKpc());
    entity.setKpp(event.getKpp());
    entity.setKpt(event.getKpt());
    entity.setKrc(event.getKrc());
    entity.setKsh(event.getKsh());
    entity.setLpi(event.getLpi());
    entity.setLps(event.getLps());
    entity.setMnef(event.getMnef());
    entity.setMxef(event.getMxef());
    entity.setPr1(event.getPr1());
    entity.setPr2(event.getPr2());
    entity.setPsmn(event.getPsmn());
    entity.setRsmimn(event.getRsmimn());
    entity.setRsmimx(event.getRsmimx());
    entity.setRvgmn(event.getRvgmn());
    entity.setRvgmx(event.getRvgmx());
    entity.setSrmn(event.getSrmn());
    entity.setSrmx(event.getSrmx());
    entity.setSrsmp(event.getSrsmp());
    entity.setSvmn(event.getSvmn());
    entity.setSvmx(event.getSvmx());
    entity.setTa(event.getTa());
    entity.setTam(event.getTam());
    entity.setTc(event.getTc());
    entity.setTcm(event.getTcm());
    entity.setTdc(event.getTdc());
    entity.setTf1(event.getTf1());
    entity.setTf2(event.getTf2());
    entity.setThp(event.getThp());
    entity.setTmp(event.getTmp());
    entity.setTrh(event.getTrh());
    entity.setTv(event.getTv());
    entity.setTy(event.getTy());
    entity.setY(event.getY());
    entity.setYhpmn(event.getYhpmn());
    entity.setYhpmx(event.getYhpmx());
    entity.setYmpmn(event.getYmpmn());
    entity.setYmpmx(event.getYmpmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event DeleteGovSteamFV4Event
   */
  @EventHandler(payloadType = DeleteGovSteamFV4Event.class)
  public void handle(DeleteGovSteamFV4Event event) {
    LOGGER.info("handling DeleteGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamFV4 entity = delete(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignCpsmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignCpsmnToGovSteamFV4Event.class)
  public void handle(AssignCpsmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignCpsmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignCpsmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignCpsmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignCpsmnFromGovSteamFV4Event.class)
  public void handle(UnAssignCpsmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignCpsmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignCpsmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignCpsmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignCpsmxToGovSteamFV4Event.class)
  public void handle(AssignCpsmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignCpsmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignCpsmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignCpsmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignCpsmxFromGovSteamFV4Event.class)
  public void handle(UnAssignCpsmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignCpsmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignCpsmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignCrmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignCrmnToGovSteamFV4Event.class)
  public void handle(AssignCrmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignCrmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignCrmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignCrmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignCrmnFromGovSteamFV4Event.class)
  public void handle(UnAssignCrmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignCrmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignCrmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignCrmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignCrmxToGovSteamFV4Event.class)
  public void handle(AssignCrmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignCrmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignCrmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignCrmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignCrmxFromGovSteamFV4Event.class)
  public void handle(UnAssignCrmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignCrmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignCrmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKdcToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKdcToGovSteamFV4Event.class)
  public void handle(AssignKdcToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKdcToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKdc(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKdcFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKdcFromGovSteamFV4Event.class)
  public void handle(UnAssignKdcFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKdcFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKdc(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKf1ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKf1ToGovSteamFV4Event.class)
  public void handle(AssignKf1ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKf1ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKf1(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKf1FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKf1FromGovSteamFV4Event.class)
  public void handle(UnAssignKf1FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKf1FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKf1(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKf3ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKf3ToGovSteamFV4Event.class)
  public void handle(AssignKf3ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKf3ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKf3(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKf3FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKf3FromGovSteamFV4Event.class)
  public void handle(UnAssignKf3FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKf3FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKf3(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKhpToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKhpToGovSteamFV4Event.class)
  public void handle(AssignKhpToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKhpToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKhp(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKhpFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKhpFromGovSteamFV4Event.class)
  public void handle(UnAssignKhpFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKhpFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKhp(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKicToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKicToGovSteamFV4Event.class)
  public void handle(AssignKicToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKicToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKic(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKicFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKicFromGovSteamFV4Event.class)
  public void handle(UnAssignKicFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKicFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKic(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKipToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKipToGovSteamFV4Event.class)
  public void handle(AssignKipToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKipToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKip(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKipFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKipFromGovSteamFV4Event.class)
  public void handle(UnAssignKipFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKipFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKip(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKitToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKitToGovSteamFV4Event.class)
  public void handle(AssignKitToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKitToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKit(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKitFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKitFromGovSteamFV4Event.class)
  public void handle(UnAssignKitFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKitFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKit(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKmp1ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKmp1ToGovSteamFV4Event.class)
  public void handle(AssignKmp1ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKmp1ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKmp1(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKmp1FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKmp1FromGovSteamFV4Event.class)
  public void handle(UnAssignKmp1FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKmp1FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKmp1(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKmp2ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKmp2ToGovSteamFV4Event.class)
  public void handle(AssignKmp2ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKmp2ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKmp2(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKmp2FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKmp2FromGovSteamFV4Event.class)
  public void handle(UnAssignKmp2FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKmp2FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKmp2(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKpcToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKpcToGovSteamFV4Event.class)
  public void handle(AssignKpcToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKpcToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKpc(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKpcFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKpcFromGovSteamFV4Event.class)
  public void handle(UnAssignKpcFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKpcFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKpc(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKppToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKppToGovSteamFV4Event.class)
  public void handle(AssignKppToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKppToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKpp(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKppFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKppFromGovSteamFV4Event.class)
  public void handle(UnAssignKppFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKppFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKpp(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKptToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKptToGovSteamFV4Event.class)
  public void handle(AssignKptToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKptToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKpt(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKptFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKptFromGovSteamFV4Event.class)
  public void handle(UnAssignKptFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKptFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKpt(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKrcToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKrcToGovSteamFV4Event.class)
  public void handle(AssignKrcToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKrcToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKrc(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKrcFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKrcFromGovSteamFV4Event.class)
  public void handle(UnAssignKrcFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKrcFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKrc(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignKshToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignKshToGovSteamFV4Event.class)
  public void handle(AssignKshToGovSteamFV4Event event) {
    LOGGER.info("handling AssignKshToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignKsh(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignKshFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignKshFromGovSteamFV4Event.class)
  public void handle(UnAssignKshFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignKshFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignKsh(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignLpiToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignLpiToGovSteamFV4Event.class)
  public void handle(AssignLpiToGovSteamFV4Event event) {
    LOGGER.info("handling AssignLpiToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignLpi(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignLpiFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignLpiFromGovSteamFV4Event.class)
  public void handle(UnAssignLpiFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignLpiFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignLpi(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignLpsToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignLpsToGovSteamFV4Event.class)
  public void handle(AssignLpsToGovSteamFV4Event event) {
    LOGGER.info("handling AssignLpsToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignLps(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignLpsFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignLpsFromGovSteamFV4Event.class)
  public void handle(UnAssignLpsFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignLpsFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignLps(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignMnefToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignMnefToGovSteamFV4Event.class)
  public void handle(AssignMnefToGovSteamFV4Event event) {
    LOGGER.info("handling AssignMnefToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignMnef(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignMnefFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignMnefFromGovSteamFV4Event.class)
  public void handle(UnAssignMnefFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignMnefFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignMnef(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignMxefToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignMxefToGovSteamFV4Event.class)
  public void handle(AssignMxefToGovSteamFV4Event event) {
    LOGGER.info("handling AssignMxefToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignMxef(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignMxefFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignMxefFromGovSteamFV4Event.class)
  public void handle(UnAssignMxefFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignMxefFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignMxef(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignPr1ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignPr1ToGovSteamFV4Event.class)
  public void handle(AssignPr1ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignPr1ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignPr1(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignPr1FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignPr1FromGovSteamFV4Event.class)
  public void handle(UnAssignPr1FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignPr1FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignPr1(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignPr2ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignPr2ToGovSteamFV4Event.class)
  public void handle(AssignPr2ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignPr2ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignPr2(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignPr2FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignPr2FromGovSteamFV4Event.class)
  public void handle(UnAssignPr2FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignPr2FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignPr2(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignPsmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignPsmnToGovSteamFV4Event.class)
  public void handle(AssignPsmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignPsmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignPsmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignPsmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignPsmnFromGovSteamFV4Event.class)
  public void handle(UnAssignPsmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignPsmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignPsmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignRsmimnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignRsmimnToGovSteamFV4Event.class)
  public void handle(AssignRsmimnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignRsmimnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignRsmimn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignRsmimnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignRsmimnFromGovSteamFV4Event.class)
  public void handle(UnAssignRsmimnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignRsmimnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignRsmimn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignRsmimxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignRsmimxToGovSteamFV4Event.class)
  public void handle(AssignRsmimxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignRsmimxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignRsmimx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignRsmimxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignRsmimxFromGovSteamFV4Event.class)
  public void handle(UnAssignRsmimxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignRsmimxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignRsmimx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignRvgmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignRvgmnToGovSteamFV4Event.class)
  public void handle(AssignRvgmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignRvgmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignRvgmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignRvgmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignRvgmnFromGovSteamFV4Event.class)
  public void handle(UnAssignRvgmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignRvgmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignRvgmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignRvgmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignRvgmxToGovSteamFV4Event.class)
  public void handle(AssignRvgmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignRvgmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignRvgmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignRvgmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignRvgmxFromGovSteamFV4Event.class)
  public void handle(UnAssignRvgmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignRvgmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignRvgmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignSrmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignSrmnToGovSteamFV4Event.class)
  public void handle(AssignSrmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignSrmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignSrmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignSrmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignSrmnFromGovSteamFV4Event.class)
  public void handle(UnAssignSrmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignSrmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignSrmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignSrmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignSrmxToGovSteamFV4Event.class)
  public void handle(AssignSrmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignSrmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignSrmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignSrmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignSrmxFromGovSteamFV4Event.class)
  public void handle(UnAssignSrmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignSrmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignSrmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignSrsmpToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignSrsmpToGovSteamFV4Event.class)
  public void handle(AssignSrsmpToGovSteamFV4Event event) {
    LOGGER.info("handling AssignSrsmpToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignSrsmp(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignSrsmpFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignSrsmpFromGovSteamFV4Event.class)
  public void handle(UnAssignSrsmpFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignSrsmpFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignSrsmp(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignSvmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignSvmnToGovSteamFV4Event.class)
  public void handle(AssignSvmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignSvmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignSvmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignSvmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignSvmnFromGovSteamFV4Event.class)
  public void handle(UnAssignSvmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignSvmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignSvmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignSvmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignSvmxToGovSteamFV4Event.class)
  public void handle(AssignSvmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignSvmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignSvmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignSvmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignSvmxFromGovSteamFV4Event.class)
  public void handle(UnAssignSvmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignSvmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignSvmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTaToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTaToGovSteamFV4Event.class)
  public void handle(AssignTaToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTaToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTa(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTaFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovSteamFV4Event.class)
  public void handle(UnAssignTaFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTaFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTa(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTamToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTamToGovSteamFV4Event.class)
  public void handle(AssignTamToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTamToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTam(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTamFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTamFromGovSteamFV4Event.class)
  public void handle(UnAssignTamFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTamFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTam(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTcToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTcToGovSteamFV4Event.class)
  public void handle(AssignTcToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTcToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTc(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTcFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovSteamFV4Event.class)
  public void handle(UnAssignTcFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTcFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTc(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTcmToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTcmToGovSteamFV4Event.class)
  public void handle(AssignTcmToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTcmToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTcm(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTcmFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTcmFromGovSteamFV4Event.class)
  public void handle(UnAssignTcmFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTcmFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTcm(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTdcToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTdcToGovSteamFV4Event.class)
  public void handle(AssignTdcToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTdcToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTdc(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTdcFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTdcFromGovSteamFV4Event.class)
  public void handle(UnAssignTdcFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTdcFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTdc(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTf1ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTf1ToGovSteamFV4Event.class)
  public void handle(AssignTf1ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTf1ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTf1(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTf1FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTf1FromGovSteamFV4Event.class)
  public void handle(UnAssignTf1FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTf1FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTf1(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTf2ToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTf2ToGovSteamFV4Event.class)
  public void handle(AssignTf2ToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTf2ToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTf2(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTf2FromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTf2FromGovSteamFV4Event.class)
  public void handle(UnAssignTf2FromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTf2FromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTf2(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignThpToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignThpToGovSteamFV4Event.class)
  public void handle(AssignThpToGovSteamFV4Event event) {
    LOGGER.info("handling AssignThpToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignThp(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignThpFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignThpFromGovSteamFV4Event.class)
  public void handle(UnAssignThpFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignThpFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignThp(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTmpToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTmpToGovSteamFV4Event.class)
  public void handle(AssignTmpToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTmpToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTmp(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTmpFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTmpFromGovSteamFV4Event.class)
  public void handle(UnAssignTmpFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTmpFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTmp(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTrhToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTrhToGovSteamFV4Event.class)
  public void handle(AssignTrhToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTrhToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTrh(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTrhFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTrhFromGovSteamFV4Event.class)
  public void handle(UnAssignTrhFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTrhFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTrh(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTvToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTvToGovSteamFV4Event.class)
  public void handle(AssignTvToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTvToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTv(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTvFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTvFromGovSteamFV4Event.class)
  public void handle(UnAssignTvFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTvFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTv(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignTyToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignTyToGovSteamFV4Event.class)
  public void handle(AssignTyToGovSteamFV4Event event) {
    LOGGER.info("handling AssignTyToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignTy(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignTyFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignTyFromGovSteamFV4Event.class)
  public void handle(UnAssignTyFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignTyFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignTy(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignYToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignYToGovSteamFV4Event.class)
  public void handle(AssignYToGovSteamFV4Event event) {
    LOGGER.info("handling AssignYToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignY(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignYFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignYFromGovSteamFV4Event.class)
  public void handle(UnAssignYFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignYFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignY(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignYhpmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignYhpmnToGovSteamFV4Event.class)
  public void handle(AssignYhpmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignYhpmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignYhpmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignYhpmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignYhpmnFromGovSteamFV4Event.class)
  public void handle(UnAssignYhpmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignYhpmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignYhpmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignYhpmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignYhpmxToGovSteamFV4Event.class)
  public void handle(AssignYhpmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignYhpmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignYhpmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignYhpmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignYhpmxFromGovSteamFV4Event.class)
  public void handle(UnAssignYhpmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignYhpmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignYhpmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignYmpmnToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignYmpmnToGovSteamFV4Event.class)
  public void handle(AssignYmpmnToGovSteamFV4Event event) {
    LOGGER.info("handling AssignYmpmnToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignYmpmn(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignYmpmnFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignYmpmnFromGovSteamFV4Event.class)
  public void handle(UnAssignYmpmnFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignYmpmnFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignYmpmn(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event AssignYmpmxToGovSteamFV4Event
   */
  @EventHandler(payloadType = AssignYmpmxToGovSteamFV4Event.class)
  public void handle(AssignYmpmxToGovSteamFV4Event event) {
    LOGGER.info("handling AssignYmpmxToGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV4 entity = assignYmpmx(event.getGovSteamFV4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /*
   * @param	event UnAssignYmpmxFromGovSteamFV4Event
   */
  @EventHandler(payloadType = UnAssignYmpmxFromGovSteamFV4Event.class)
  public void handle(UnAssignYmpmxFromGovSteamFV4Event event) {
    LOGGER.info("handling UnAssignYmpmxFromGovSteamFV4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV4 entity = unAssignYmpmx(event.getGovSteamFV4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV4(entity);
  }

  /**
   * Method to retrieve the GovSteamFV4 via an GovSteamFV4PrimaryKey.
   *
   * @param id Long
   * @return GovSteamFV4
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamFV4 handle(FindGovSteamFV4Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamFV4Id());
  }

  /**
   * Method to retrieve a collection of all GovSteamFV4s
   *
   * @param query FindAllGovSteamFV4Query
   * @return List<GovSteamFV4>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamFV4> handle(FindAllGovSteamFV4Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamFV4, but only if the id matches
   *
   * @param entity GovSteamFV4
   */
  protected void emitFindGovSteamFV4(GovSteamFV4 entity) {
    LOGGER.info("handling emitFindGovSteamFV4");

    queryUpdateEmitter.emit(
        FindGovSteamFV4Query.class,
        query -> query.getFilter().getGovSteamFV4Id().equals(entity.getGovSteamFV4Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamFV4
   *
   * @param entity GovSteamFV4
   */
  protected void emitFindAllGovSteamFV4(GovSteamFV4 entity) {
    LOGGER.info("handling emitFindAllGovSteamFV4");

    queryUpdateEmitter.emit(FindAllGovSteamFV4Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamFV4Projector.class.getName());
}
