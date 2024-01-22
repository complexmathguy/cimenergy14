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
 * Projector for GovCT1 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovCT1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovCT1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govCT1")
@Component("govCT1-projector")
public class GovCT1Projector extends GovCT1EntityProjector {

  // core constructor
  public GovCT1Projector(GovCT1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovCT1Event
   */
  @EventHandler(payloadType = CreateGovCT1Event.class)
  public void handle(CreateGovCT1Event event) {
    LOGGER.info("handling CreateGovCT1Event - " + event);
    GovCT1 entity = new GovCT1();
    entity.setGovCT1Id(event.getGovCT1Id());
    entity.setRselect(event.getRselect());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UpdateGovCT1Event
   */
  @EventHandler(payloadType = UpdateGovCT1Event.class)
  public void handle(UpdateGovCT1Event event) {
    LOGGER.info("handling UpdateGovCT1Event - " + event);

    GovCT1 entity = new GovCT1();
    entity.setGovCT1Id(event.getGovCT1Id());
    entity.setAset(event.getAset());
    entity.setDb(event.getDb());
    entity.setDm(event.getDm());
    entity.setKa(event.getKa());
    entity.setKdgov(event.getKdgov());
    entity.setKigov(event.getKigov());
    entity.setKiload(event.getKiload());
    entity.setKimw(event.getKimw());
    entity.setKpgov(event.getKpgov());
    entity.setKpload(event.getKpload());
    entity.setKturb(event.getKturb());
    entity.setLdref(event.getLdref());
    entity.setMaxerr(event.getMaxerr());
    entity.setMinerr(event.getMinerr());
    entity.setMwbase(event.getMwbase());
    entity.setR(event.getR());
    entity.setRclose(event.getRclose());
    entity.setRdown(event.getRdown());
    entity.setRopen(event.getRopen());
    entity.setRselect(event.getRselect());
    entity.setRup(event.getRup());
    entity.setTa(event.getTa());
    entity.setTact(event.getTact());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTdgov(event.getTdgov());
    entity.setTeng(event.getTeng());
    entity.setTfload(event.getTfload());
    entity.setTpelec(event.getTpelec());
    entity.setTsa(event.getTsa());
    entity.setTsb(event.getTsb());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());
    entity.setWfnl(event.getWfnl());
    entity.setWfspd(event.getWfspd());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event DeleteGovCT1Event
   */
  @EventHandler(payloadType = DeleteGovCT1Event.class)
  public void handle(DeleteGovCT1Event event) {
    LOGGER.info("handling DeleteGovCT1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovCT1 entity = delete(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignAsetToGovCT1Event
   */
  @EventHandler(payloadType = AssignAsetToGovCT1Event.class)
  public void handle(AssignAsetToGovCT1Event event) {
    LOGGER.info("handling AssignAsetToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignAset(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignAsetFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignAsetFromGovCT1Event.class)
  public void handle(UnAssignAsetFromGovCT1Event event) {
    LOGGER.info("handling UnAssignAsetFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignAset(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignDbToGovCT1Event
   */
  @EventHandler(payloadType = AssignDbToGovCT1Event.class)
  public void handle(AssignDbToGovCT1Event event) {
    LOGGER.info("handling AssignDbToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignDb(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignDbFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignDbFromGovCT1Event.class)
  public void handle(UnAssignDbFromGovCT1Event event) {
    LOGGER.info("handling UnAssignDbFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignDb(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignDmToGovCT1Event
   */
  @EventHandler(payloadType = AssignDmToGovCT1Event.class)
  public void handle(AssignDmToGovCT1Event event) {
    LOGGER.info("handling AssignDmToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignDm(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignDmFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignDmFromGovCT1Event.class)
  public void handle(UnAssignDmFromGovCT1Event event) {
    LOGGER.info("handling UnAssignDmFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignDm(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKaToGovCT1Event
   */
  @EventHandler(payloadType = AssignKaToGovCT1Event.class)
  public void handle(AssignKaToGovCT1Event event) {
    LOGGER.info("handling AssignKaToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKa(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKaFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKaFromGovCT1Event.class)
  public void handle(UnAssignKaFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKaFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKa(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKdgovToGovCT1Event
   */
  @EventHandler(payloadType = AssignKdgovToGovCT1Event.class)
  public void handle(AssignKdgovToGovCT1Event event) {
    LOGGER.info("handling AssignKdgovToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKdgov(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKdgovFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKdgovFromGovCT1Event.class)
  public void handle(UnAssignKdgovFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKdgovFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKdgov(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKigovToGovCT1Event
   */
  @EventHandler(payloadType = AssignKigovToGovCT1Event.class)
  public void handle(AssignKigovToGovCT1Event event) {
    LOGGER.info("handling AssignKigovToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKigov(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKigovFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKigovFromGovCT1Event.class)
  public void handle(UnAssignKigovFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKigovFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKigov(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKiloadToGovCT1Event
   */
  @EventHandler(payloadType = AssignKiloadToGovCT1Event.class)
  public void handle(AssignKiloadToGovCT1Event event) {
    LOGGER.info("handling AssignKiloadToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKiload(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKiloadFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKiloadFromGovCT1Event.class)
  public void handle(UnAssignKiloadFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKiloadFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKiload(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKimwToGovCT1Event
   */
  @EventHandler(payloadType = AssignKimwToGovCT1Event.class)
  public void handle(AssignKimwToGovCT1Event event) {
    LOGGER.info("handling AssignKimwToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKimw(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKimwFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKimwFromGovCT1Event.class)
  public void handle(UnAssignKimwFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKimwFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKimw(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKpgovToGovCT1Event
   */
  @EventHandler(payloadType = AssignKpgovToGovCT1Event.class)
  public void handle(AssignKpgovToGovCT1Event event) {
    LOGGER.info("handling AssignKpgovToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKpgov(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKpgovFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKpgovFromGovCT1Event.class)
  public void handle(UnAssignKpgovFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKpgovFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKpgov(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKploadToGovCT1Event
   */
  @EventHandler(payloadType = AssignKploadToGovCT1Event.class)
  public void handle(AssignKploadToGovCT1Event event) {
    LOGGER.info("handling AssignKploadToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKpload(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKploadFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKploadFromGovCT1Event.class)
  public void handle(UnAssignKploadFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKploadFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKpload(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignKturbToGovCT1Event
   */
  @EventHandler(payloadType = AssignKturbToGovCT1Event.class)
  public void handle(AssignKturbToGovCT1Event event) {
    LOGGER.info("handling AssignKturbToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignKturb(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignKturbFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignKturbFromGovCT1Event.class)
  public void handle(UnAssignKturbFromGovCT1Event event) {
    LOGGER.info("handling UnAssignKturbFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignKturb(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignLdrefToGovCT1Event
   */
  @EventHandler(payloadType = AssignLdrefToGovCT1Event.class)
  public void handle(AssignLdrefToGovCT1Event event) {
    LOGGER.info("handling AssignLdrefToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignLdref(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignLdrefFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignLdrefFromGovCT1Event.class)
  public void handle(UnAssignLdrefFromGovCT1Event event) {
    LOGGER.info("handling UnAssignLdrefFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignLdref(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignMaxerrToGovCT1Event
   */
  @EventHandler(payloadType = AssignMaxerrToGovCT1Event.class)
  public void handle(AssignMaxerrToGovCT1Event event) {
    LOGGER.info("handling AssignMaxerrToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignMaxerr(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignMaxerrFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignMaxerrFromGovCT1Event.class)
  public void handle(UnAssignMaxerrFromGovCT1Event event) {
    LOGGER.info("handling UnAssignMaxerrFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignMaxerr(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignMinerrToGovCT1Event
   */
  @EventHandler(payloadType = AssignMinerrToGovCT1Event.class)
  public void handle(AssignMinerrToGovCT1Event event) {
    LOGGER.info("handling AssignMinerrToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignMinerr(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignMinerrFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignMinerrFromGovCT1Event.class)
  public void handle(UnAssignMinerrFromGovCT1Event event) {
    LOGGER.info("handling UnAssignMinerrFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignMinerr(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignMwbaseToGovCT1Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovCT1Event.class)
  public void handle(AssignMwbaseToGovCT1Event event) {
    LOGGER.info("handling AssignMwbaseToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignMwbase(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovCT1Event.class)
  public void handle(UnAssignMwbaseFromGovCT1Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignMwbase(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignRToGovCT1Event
   */
  @EventHandler(payloadType = AssignRToGovCT1Event.class)
  public void handle(AssignRToGovCT1Event event) {
    LOGGER.info("handling AssignRToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignR(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignRFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignRFromGovCT1Event.class)
  public void handle(UnAssignRFromGovCT1Event event) {
    LOGGER.info("handling UnAssignRFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignR(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignRcloseToGovCT1Event
   */
  @EventHandler(payloadType = AssignRcloseToGovCT1Event.class)
  public void handle(AssignRcloseToGovCT1Event event) {
    LOGGER.info("handling AssignRcloseToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignRclose(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignRcloseFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignRcloseFromGovCT1Event.class)
  public void handle(UnAssignRcloseFromGovCT1Event event) {
    LOGGER.info("handling UnAssignRcloseFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignRclose(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignRdownToGovCT1Event
   */
  @EventHandler(payloadType = AssignRdownToGovCT1Event.class)
  public void handle(AssignRdownToGovCT1Event event) {
    LOGGER.info("handling AssignRdownToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignRdown(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignRdownFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignRdownFromGovCT1Event.class)
  public void handle(UnAssignRdownFromGovCT1Event event) {
    LOGGER.info("handling UnAssignRdownFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignRdown(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignRopenToGovCT1Event
   */
  @EventHandler(payloadType = AssignRopenToGovCT1Event.class)
  public void handle(AssignRopenToGovCT1Event event) {
    LOGGER.info("handling AssignRopenToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignRopen(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignRopenFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignRopenFromGovCT1Event.class)
  public void handle(UnAssignRopenFromGovCT1Event event) {
    LOGGER.info("handling UnAssignRopenFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignRopen(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignRupToGovCT1Event
   */
  @EventHandler(payloadType = AssignRupToGovCT1Event.class)
  public void handle(AssignRupToGovCT1Event event) {
    LOGGER.info("handling AssignRupToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignRup(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignRupFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignRupFromGovCT1Event.class)
  public void handle(UnAssignRupFromGovCT1Event event) {
    LOGGER.info("handling UnAssignRupFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignRup(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTaToGovCT1Event
   */
  @EventHandler(payloadType = AssignTaToGovCT1Event.class)
  public void handle(AssignTaToGovCT1Event event) {
    LOGGER.info("handling AssignTaToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTa(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTaFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovCT1Event.class)
  public void handle(UnAssignTaFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTaFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTa(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTactToGovCT1Event
   */
  @EventHandler(payloadType = AssignTactToGovCT1Event.class)
  public void handle(AssignTactToGovCT1Event event) {
    LOGGER.info("handling AssignTactToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTact(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTactFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTactFromGovCT1Event.class)
  public void handle(UnAssignTactFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTactFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTact(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTbToGovCT1Event
   */
  @EventHandler(payloadType = AssignTbToGovCT1Event.class)
  public void handle(AssignTbToGovCT1Event event) {
    LOGGER.info("handling AssignTbToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTb(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTbFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTbFromGovCT1Event.class)
  public void handle(UnAssignTbFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTbFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTb(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTcToGovCT1Event
   */
  @EventHandler(payloadType = AssignTcToGovCT1Event.class)
  public void handle(AssignTcToGovCT1Event event) {
    LOGGER.info("handling AssignTcToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTc(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTcFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovCT1Event.class)
  public void handle(UnAssignTcFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTcFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTc(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTdgovToGovCT1Event
   */
  @EventHandler(payloadType = AssignTdgovToGovCT1Event.class)
  public void handle(AssignTdgovToGovCT1Event event) {
    LOGGER.info("handling AssignTdgovToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTdgov(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTdgovFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTdgovFromGovCT1Event.class)
  public void handle(UnAssignTdgovFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTdgovFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTdgov(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTengToGovCT1Event
   */
  @EventHandler(payloadType = AssignTengToGovCT1Event.class)
  public void handle(AssignTengToGovCT1Event event) {
    LOGGER.info("handling AssignTengToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTeng(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTengFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTengFromGovCT1Event.class)
  public void handle(UnAssignTengFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTengFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTeng(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTfloadToGovCT1Event
   */
  @EventHandler(payloadType = AssignTfloadToGovCT1Event.class)
  public void handle(AssignTfloadToGovCT1Event event) {
    LOGGER.info("handling AssignTfloadToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTfload(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTfloadFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTfloadFromGovCT1Event.class)
  public void handle(UnAssignTfloadFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTfloadFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTfload(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTpelecToGovCT1Event
   */
  @EventHandler(payloadType = AssignTpelecToGovCT1Event.class)
  public void handle(AssignTpelecToGovCT1Event event) {
    LOGGER.info("handling AssignTpelecToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTpelec(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTpelecFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTpelecFromGovCT1Event.class)
  public void handle(UnAssignTpelecFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTpelecFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTpelec(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTsaToGovCT1Event
   */
  @EventHandler(payloadType = AssignTsaToGovCT1Event.class)
  public void handle(AssignTsaToGovCT1Event event) {
    LOGGER.info("handling AssignTsaToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTsa(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTsaFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTsaFromGovCT1Event.class)
  public void handle(UnAssignTsaFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTsaFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTsa(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignTsbToGovCT1Event
   */
  @EventHandler(payloadType = AssignTsbToGovCT1Event.class)
  public void handle(AssignTsbToGovCT1Event event) {
    LOGGER.info("handling AssignTsbToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignTsb(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignTsbFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignTsbFromGovCT1Event.class)
  public void handle(UnAssignTsbFromGovCT1Event event) {
    LOGGER.info("handling UnAssignTsbFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignTsb(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignVmaxToGovCT1Event
   */
  @EventHandler(payloadType = AssignVmaxToGovCT1Event.class)
  public void handle(AssignVmaxToGovCT1Event event) {
    LOGGER.info("handling AssignVmaxToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignVmax(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignVmaxFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignVmaxFromGovCT1Event.class)
  public void handle(UnAssignVmaxFromGovCT1Event event) {
    LOGGER.info("handling UnAssignVmaxFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignVmax(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignVminToGovCT1Event
   */
  @EventHandler(payloadType = AssignVminToGovCT1Event.class)
  public void handle(AssignVminToGovCT1Event event) {
    LOGGER.info("handling AssignVminToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignVmin(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignVminFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignVminFromGovCT1Event.class)
  public void handle(UnAssignVminFromGovCT1Event event) {
    LOGGER.info("handling UnAssignVminFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignVmin(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignWfnlToGovCT1Event
   */
  @EventHandler(payloadType = AssignWfnlToGovCT1Event.class)
  public void handle(AssignWfnlToGovCT1Event event) {
    LOGGER.info("handling AssignWfnlToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignWfnl(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignWfnlFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignWfnlFromGovCT1Event.class)
  public void handle(UnAssignWfnlFromGovCT1Event event) {
    LOGGER.info("handling UnAssignWfnlFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignWfnl(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event AssignWfspdToGovCT1Event
   */
  @EventHandler(payloadType = AssignWfspdToGovCT1Event.class)
  public void handle(AssignWfspdToGovCT1Event event) {
    LOGGER.info("handling AssignWfspdToGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovCT1 entity = assignWfspd(event.getGovCT1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /*
   * @param	event UnAssignWfspdFromGovCT1Event
   */
  @EventHandler(payloadType = UnAssignWfspdFromGovCT1Event.class)
  public void handle(UnAssignWfspdFromGovCT1Event event) {
    LOGGER.info("handling UnAssignWfspdFromGovCT1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovCT1 entity = unAssignWfspd(event.getGovCT1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovCT1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovCT1(entity);
  }

  /**
   * Method to retrieve the GovCT1 via an GovCT1PrimaryKey.
   *
   * @param id Long
   * @return GovCT1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovCT1 handle(FindGovCT1Query query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovCT1Id());
  }

  /**
   * Method to retrieve a collection of all GovCT1s
   *
   * @param query FindAllGovCT1Query
   * @return List<GovCT1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovCT1> handle(FindAllGovCT1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovCT1, but only if the id matches
   *
   * @param entity GovCT1
   */
  protected void emitFindGovCT1(GovCT1 entity) {
    LOGGER.info("handling emitFindGovCT1");

    queryUpdateEmitter.emit(
        FindGovCT1Query.class,
        query -> query.getFilter().getGovCT1Id().equals(entity.getGovCT1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovCT1
   *
   * @param entity GovCT1
   */
  protected void emitFindAllGovCT1(GovCT1 entity) {
    LOGGER.info("handling emitFindAllGovCT1");

    queryUpdateEmitter.emit(FindAllGovCT1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovCT1Projector.class.getName());
}
