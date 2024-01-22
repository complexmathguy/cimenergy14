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
 * WindContCurrLimIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindContCurrLimIEC related services in the case of a
 *       WindContCurrLimIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindContCurrLimIEC interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindContCurrLimIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindContCurrLimIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindContCurrLimIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindContCurrLimIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindContCurrLimIECBusinessDelegate
   */
  public static WindContCurrLimIECBusinessDelegate getWindContCurrLimIECInstance() {
    return (new WindContCurrLimIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindContCurrLimIEC(CreateWindContCurrLimIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindContCurrLimIECId() == null)
        command.setWindContCurrLimIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindContCurrLimIECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindContCurrLimIECCommand of WindContCurrLimIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindContCurrLimIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindContCurrLimIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindContCurrLimIEC(UpdateWindContCurrLimIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindContCurrLimIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindContCurrLimIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindContCurrLimIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindContCurrLimIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindContCurrLimIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindContCurrLimIEC using Id = " + command.getWindContCurrLimIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindContCurrLimIEC via WindContCurrLimIECFetchOneSummary
   *
   * @param summary WindContCurrLimIECFetchOneSummary
   * @return WindContCurrLimIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindContCurrLimIEC getWindContCurrLimIEC(WindContCurrLimIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindContCurrLimIECFetchOneSummary arg cannot be null");

    WindContCurrLimIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindContCurrLimIEC
      // --------------------------------------
      CompletableFuture<WindContCurrLimIEC> futureEntity =
          queryGateway.query(
              new FindWindContCurrLimIECQuery(
                  new LoadWindContCurrLimIECFilter(summary.getWindContCurrLimIECId())),
              ResponseTypes.instanceOf(WindContCurrLimIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindContCurrLimIEC with id " + summary.getWindContCurrLimIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindContCurrLimIECs
   *
   * @return List<WindContCurrLimIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindContCurrLimIEC> getAllWindContCurrLimIEC() throws ProcessingException {
    List<WindContCurrLimIEC> list = null;

    try {
      CompletableFuture<List<WindContCurrLimIEC>> futureList =
          queryGateway.query(
              new FindAllWindContCurrLimIECQuery(),
              ResponseTypes.multipleInstancesOf(WindContCurrLimIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindContCurrLimIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Imax on WindContCurrLimIEC
   *
   * @param command AssignImaxToWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void assignImax(AssignImaxToWindContCurrLimIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContCurrLimIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContCurrLimIECBusinessDelegate parentDelegate =
        WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

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
   * unAssign Imax on WindContCurrLimIEC
   *
   * @param command UnAssignImaxFromWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void unAssignImax(UnAssignImaxFromWindContCurrLimIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Imax on WindContCurrLimIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Imaxdip on WindContCurrLimIEC
   *
   * @param command AssignImaxdipToWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void assignImaxdip(AssignImaxdipToWindContCurrLimIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContCurrLimIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContCurrLimIECBusinessDelegate parentDelegate =
        WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

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
   * unAssign Imaxdip on WindContCurrLimIEC
   *
   * @param command UnAssignImaxdipFromWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void unAssignImaxdip(UnAssignImaxdipFromWindContCurrLimIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Imaxdip on WindContCurrLimIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mdfslim on WindContCurrLimIEC
   *
   * @param command AssignMdfslimToWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void assignMdfslim(AssignMdfslimToWindContCurrLimIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContCurrLimIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    WindContCurrLimIECBusinessDelegate parentDelegate =
        WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Mdfslim on WindContCurrLimIEC
   *
   * @param command UnAssignMdfslimFromWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void unAssignMdfslim(UnAssignMdfslimFromWindContCurrLimIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mdfslim on WindContCurrLimIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mqpri on WindContCurrLimIEC
   *
   * @param command AssignMqpriToWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void assignMqpri(AssignMqpriToWindContCurrLimIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContCurrLimIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    WindContCurrLimIECBusinessDelegate parentDelegate =
        WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Mqpri on WindContCurrLimIEC
   *
   * @param command UnAssignMqpriFromWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void unAssignMqpri(UnAssignMqpriFromWindContCurrLimIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mqpri on WindContCurrLimIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tufilt on WindContCurrLimIEC
   *
   * @param command AssignTufiltToWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void assignTufilt(AssignTufiltToWindContCurrLimIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContCurrLimIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContCurrLimIECBusinessDelegate parentDelegate =
        WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tufilt on WindContCurrLimIEC
   *
   * @param command UnAssignTufiltFromWindContCurrLimIECCommand
   * @exception ProcessingException
   */
  public void unAssignTufilt(UnAssignTufiltFromWindContCurrLimIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContCurrLimIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tufilt on WindContCurrLimIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindContCurrLimIEC
   */
  private WindContCurrLimIEC load(UUID id) throws ProcessingException {
    windContCurrLimIEC =
        WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance()
            .getWindContCurrLimIEC(new WindContCurrLimIECFetchOneSummary(id));
    return windContCurrLimIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindContCurrLimIEC windContCurrLimIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContCurrLimIECBusinessDelegate.class.getName());
}
