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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * WindAeroLinearIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindAeroLinearIEC related services in the case of a
 *       WindAeroLinearIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindAeroLinearIEC interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindAeroLinearIEC business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindAeroLinearIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindAeroLinearIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindAeroLinearIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindAeroLinearIECBusinessDelegate
   */
  public static WindAeroLinearIECBusinessDelegate getWindAeroLinearIECInstance() {
    return (new WindAeroLinearIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindAeroLinearIEC(CreateWindAeroLinearIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindAeroLinearIECId() == null)
        command.setWindAeroLinearIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindAeroLinearIECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindAeroLinearIECCommand of WindAeroLinearIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindAeroLinearIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindAeroLinearIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindAeroLinearIEC(UpdateWindAeroLinearIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindAeroLinearIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindAeroLinearIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindAeroLinearIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindAeroLinearIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindAeroLinearIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindAeroLinearIEC using Id = " + command.getWindAeroLinearIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindAeroLinearIEC via WindAeroLinearIECFetchOneSummary
   *
   * @param summary WindAeroLinearIECFetchOneSummary
   * @return WindAeroLinearIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindAeroLinearIEC getWindAeroLinearIEC(WindAeroLinearIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindAeroLinearIECFetchOneSummary arg cannot be null");

    WindAeroLinearIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindAeroLinearIEC
      // --------------------------------------
      CompletableFuture<WindAeroLinearIEC> futureEntity =
          queryGateway.query(
              new FindWindAeroLinearIECQuery(
                  new LoadWindAeroLinearIECFilter(summary.getWindAeroLinearIECId())),
              ResponseTypes.instanceOf(WindAeroLinearIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindAeroLinearIEC with id " + summary.getWindAeroLinearIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindAeroLinearIECs
   *
   * @return List<WindAeroLinearIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindAeroLinearIEC> getAllWindAeroLinearIEC() throws ProcessingException {
    List<WindAeroLinearIEC> list = null;

    try {
      CompletableFuture<List<WindAeroLinearIEC>> futureList =
          queryGateway.query(
              new FindAllWindAeroLinearIECQuery(),
              ResponseTypes.multipleInstancesOf(WindAeroLinearIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindAeroLinearIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Dpomega on WindAeroLinearIEC
   *
   * @param command AssignDpomegaToWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void assignDpomega(AssignDpomegaToWindAeroLinearIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindAeroLinearIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindAeroLinearIECBusinessDelegate parentDelegate =
        WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Dpomega on WindAeroLinearIEC
   *
   * @param command UnAssignDpomegaFromWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void unAssignDpomega(UnAssignDpomegaFromWindAeroLinearIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dpomega on WindAeroLinearIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dptheta on WindAeroLinearIEC
   *
   * @param command AssignDpthetaToWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void assignDptheta(AssignDpthetaToWindAeroLinearIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindAeroLinearIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindAeroLinearIECBusinessDelegate parentDelegate =
        WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Dptheta on WindAeroLinearIEC
   *
   * @param command UnAssignDpthetaFromWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void unAssignDptheta(UnAssignDpthetaFromWindAeroLinearIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dptheta on WindAeroLinearIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Omegazero on WindAeroLinearIEC
   *
   * @param command AssignOmegazeroToWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void assignOmegazero(AssignOmegazeroToWindAeroLinearIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindAeroLinearIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindAeroLinearIECBusinessDelegate parentDelegate =
        WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Omegazero on WindAeroLinearIEC
   *
   * @param command UnAssignOmegazeroFromWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void unAssignOmegazero(UnAssignOmegazeroFromWindAeroLinearIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Omegazero on WindAeroLinearIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pavail on WindAeroLinearIEC
   *
   * @param command AssignPavailToWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void assignPavail(AssignPavailToWindAeroLinearIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindAeroLinearIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindAeroLinearIECBusinessDelegate parentDelegate =
        WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Pavail on WindAeroLinearIEC
   *
   * @param command UnAssignPavailFromWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void unAssignPavail(UnAssignPavailFromWindAeroLinearIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pavail on WindAeroLinearIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Thetazero on WindAeroLinearIEC
   *
   * @param command AssignThetazeroToWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void assignThetazero(AssignThetazeroToWindAeroLinearIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindAeroLinearIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    WindAeroLinearIECBusinessDelegate parentDelegate =
        WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Thetazero on WindAeroLinearIEC
   *
   * @param command UnAssignThetazeroFromWindAeroLinearIECCommand
   * @exception ProcessingException
   */
  public void unAssignThetazero(UnAssignThetazeroFromWindAeroLinearIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindAeroLinearIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Thetazero on WindAeroLinearIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindAeroLinearIEC
   */
  private WindAeroLinearIEC load(UUID id) throws ProcessingException {
    windAeroLinearIEC =
        WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance()
            .getWindAeroLinearIEC(new WindAeroLinearIECFetchOneSummary(id));
    return windAeroLinearIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindAeroLinearIEC windAeroLinearIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindAeroLinearIECBusinessDelegate.class.getName());
}
